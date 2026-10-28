package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Bloque;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.ArrayList;
import java.util.List;

public class DefMetodo extends Nodo {

    private final Modificador modificador;
    private final boolean anotadoOverride;
    private final Tipo tipoRetorno;
    private final String nombre;
    private final List<Parametro> parametros;
    private final Bloque cuerpo;
    private InfoClase clase;
    private DefMetodo sobrescribe;
    private final List<DefMetodo> sobrescrituras = new ArrayList<>();

    public DefMetodo(Ubicacion ubicacion, Modificador modificador, boolean anotadoOverride, Tipo tipoRetorno,
                     String nombre, List<Parametro> parametros, Bloque cuerpo) {
        super(ubicacion);
        this.modificador = modificador;
        this.anotadoOverride = anotadoOverride;
        this.tipoRetorno = tipoRetorno;
        this.nombre = nombre;
        this.parametros = List.copyOf(parametros);
        this.cuerpo = cuerpo;
    }

    public Tipo getTipoRetorno() {
        return tipoRetorno;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Parametro> getParametros() {
        return parametros;
    }

    public Modificador getModificador() {
        return modificador;
    }

    /** Clase que declara el método. */
    public InfoClase getClase() {
        return clase;
    }

    /** Método del padre que este redefine con @Override, o null. */
    public DefMetodo getSobrescribe() {
        return sobrescribe;
    }

    /** Un método redefinido en alguna subclase se invoca por medio de un despachador (polimorfismo). */
    public boolean esVirtual() {
        return !sobrescrituras.isEmpty();
    }

    /** true si este método es otro o lo redefine (directa o indirectamente). */
    public boolean redefine(DefMetodo otro) {
        for (DefMetodo m = this; m != null; m = m.sobrescribe) {
            if (m == otro) return true;
        }
        return false;
    }

    public void validarFirma(ContextoSemantico ctx, InfoClase clase) {
        this.clase = clase;
        ctx.resolverTipo(tipoRetorno, this, true);
        parametros.forEach(p -> p.validarTipo(ctx));
        List<Tipo> firma = ContextoSemantico.firma(parametros);
        String texto = nombre + ctx.tiposTexto(firma, this);
        boolean repetido = clase.getMetodosPropios(nombre).stream()
                .anyMatch(otro -> ContextoSemantico.firma(otro.getParametros()).equals(firma));
        if (repetido) {
            ctx.error(this, "Ya existe un método " + texto + " en la clase " + clase.getNombre());
            return;
        }
        validarSobrescritura(ctx, clase, firma, texto);
        clase.agregarMetodo(this);
    }

    /** El polimorfismo exige @Override: con él debe existir el método en un ancestro, y sin él no puede existir. */
    private void validarSobrescritura(ContextoSemantico ctx, InfoClase clase, List<Tipo> firma, String texto) {
        DefMetodo heredado = null;
        if (clase.getPadre() != null) {
            heredado = clase.getPadre().getMetodos(nombre).stream()
                    .filter(m -> ContextoSemantico.firma(m.getParametros()).equals(firma))
                    .findFirst().orElse(null);
        }
        if (heredado == null || heredado.modificador == Modificador.PRIVADO) {
            if (anotadoOverride) {
                String motivo = heredado == null ? "ninguna superclase declara " + texto
                        : "el método " + texto + " de " + heredado.clase.getNombre() + " es private";
                ctx.error(this, "@Override inválido en " + texto + ": " + motivo);
            }
            return;
        }
        String padre = heredado.clase.getNombre();
        if (!anotadoOverride) {
            ctx.error(this, "El método " + texto + " sobrescribe al de la clase " + padre + ": debe llevar @Override");
        }
        if (!tipoRetorno.equals(heredado.tipoRetorno)) {
            ctx.error(this, "El método " + texto + " debe retornar " + ctx.nombreTipo(this, heredado.tipoRetorno)
                    + " como en la clase " + padre);
        }
        if (modificador.masRestrictivoQue(heredado.modificador)) {
            ctx.error(this, "El método " + texto + " no puede ser " + modificador.descripcion() + ": en la clase "
                    + padre + " es " + heredado.modificador.descripcion());
        }
        sobrescribe = heredado;
        heredado.sobrescrituras.add(this);
    }

    public void analizar(ContextoSemantico ctx) {
        ctx.analizarFuncion(nombre, parametros, ctx.resolverTipo(tipoRetorno, this, false), cuerpo, this,
                "El método '" + nombre + "'");
    }

    /** Marco: [0] retorno, [1] this, luego parámetros y variables locales. */
    public void generar(ContextoC3D ctx) {
        ctx.iniciarFuncion(2);
        parametros.forEach(p -> p.asignarDesplazamiento(ctx));
        cuerpo.getInstrucciones().forEach(ctx::generar);
        ctx.terminarFuncion(ctx.nombre(this));
    }
}
