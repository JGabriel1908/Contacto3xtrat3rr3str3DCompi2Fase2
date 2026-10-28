package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.SuperConstructor;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Bloque;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Instruccion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.InstruccionExpresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

public class DefConstructor extends Nodo {

    private final Modificador modificador;
    private final String nombre;
    private final List<Parametro> parametros;
    private final Bloque cuerpo;
    private DefClase clase;

    public DefConstructor(Ubicacion ubicacion, Modificador modificador, String nombre,
                          List<Parametro> parametros, Bloque cuerpo) {
        super(ubicacion);
        this.modificador = modificador;
        this.nombre = nombre;
        this.parametros = List.copyOf(parametros);
        this.cuerpo = cuerpo;
    }

    public String getNombre() { //coincidir con el de la clase
        return nombre;
    }

    public Modificador getModificador() {
        return modificador;
    }

    public List<Parametro> getParametros() {
        return parametros;
    }

    public void validarFirma(ContextoSemantico ctx, DefClase clase, List<List<Tipo>> firmasPrevias) {
        this.clase = clase;
        if (!nombre.equals(clase.getNombre())) {
            ctx.error(this, "'" + nombre + "' no tiene tipo de retorno; si es un constructor debe llamarse "
                    + clase.getNombre());
        }
        parametros.forEach(p -> p.validarTipo(ctx));
        List<Tipo> firma = ContextoSemantico.firma(parametros);
        String texto = clase.getNombre() + ctx.tiposTexto(firma, this);
        if (firmasPrevias.contains(firma)) ctx.error(this, "Ya existe un constructor " + texto);
        firmasPrevias.add(firma);
        if (!llamaASuper()) clase.verificarConstructorPadre(ctx, this);
    }

    private boolean llamaASuper() {
        List<Instruccion> instrucciones = cuerpo.getInstrucciones();
        return !instrucciones.isEmpty() && instrucciones.get(0) instanceof InstruccionExpresion ie
                && ie.getExpresion() instanceof SuperConstructor;
    }

    public void analizar(ContextoSemantico ctx) {
        List<Instruccion> instrucciones = cuerpo.getInstrucciones();
        for (int i = 1; i < instrucciones.size(); i++) {
            if (instrucciones.get(i) instanceof InstruccionExpresion ie && ie.getExpresion() instanceof SuperConstructor) {
                ctx.error(ie, "super(...) debe ser la primera instrucción del constructor");
            }
        }
        ctx.setEnConstructor(true);
        ctx.analizarFuncion(nombre + "()", parametros, Tipo.VACIO, cuerpo, this, null);
        ctx.setEnConstructor(false);
    }

    public void generar(ContextoC3D ctx) {
        ctx.iniciarFuncion(2);
        parametros.forEach(p -> p.asignarDesplazamiento(ctx));
        if (!llamaASuper()) {
            // Sin super(...) se ejecuta primero el constructor sin parámetros del padre (si lo hay)
            InfoClase padre = clase.getInfo().getPadre();
            DefConstructor implicito = padre == null ? null : InfoClase.constructorImplicito(padre);
            if (implicito != null) {
                ctx.usar(ctx.llamar(ctx.nombre(implicito), List.of(ctx.este())));
                ctx.finInstruccion();
            }
        }
        cuerpo.getInstrucciones().forEach(ctx::generar);
        ctx.terminarFuncion(ctx.nombre(this));
    }
}
