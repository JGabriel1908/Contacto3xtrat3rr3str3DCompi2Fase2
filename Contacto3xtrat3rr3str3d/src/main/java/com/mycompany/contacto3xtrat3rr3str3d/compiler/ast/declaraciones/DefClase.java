package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.TablaSimbolos;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

//clase para el zetariano
public class DefClase extends Nodo {

    private final Modificador modificador;
    private final String nombre;
    private final String nombrePadre;
    private final List<Atributo> atributos;
    private final List<DefConstructor> constructores;
    private final List<DefMetodo> metodos;
    private InfoClase info;

    public DefClase(Ubicacion ubicacion, Modificador modificador, String nombre, String nombrePadre,
                    List<Atributo> atributos, List<DefConstructor> constructores, List<DefMetodo> metodos) {
        super(ubicacion);
        this.modificador = modificador;
        this.nombre = nombre;
        this.nombrePadre = nombrePadre;
        this.atributos = List.copyOf(atributos);
        this.constructores = List.copyOf(constructores);
        this.metodos = List.copyOf(metodos);
    }

    public String getNombre() {
        return nombre;
    }

    public Modificador getModificador() {
        return modificador;
    }

    public List<DefConstructor> getConstructores() {
        return constructores;
    }

    public List<DefMetodo> getMetodos() {
        return metodos;
    }

    public InfoClase getInfo() {
        return info;
    }

    public void registrar(ContextoSemantico ctx, String archivo) {
        String nombreArchivo = new File(archivo).getName();
        String esperado = nombreArchivo.substring(0, nombreArchivo.lastIndexOf('.'));
        if (!esperado.equals(nombre)) {
            ctx.error(this, "La clase '" + nombre + "' debe estar en un archivo llamado " + nombre + ".z (está en "
                    + nombreArchivo + ")");
        }
        TablaSimbolos tabla = ctx.tabla();
        if (tabla.buscarClase(nombre) != null) {
            ctx.error(this, "Ya existe una clase llamada '" + nombre + "'");
            return;
        }
        if (tabla.buscarEstructura(nombre) != null) {
            ctx.error(this, "El nombre '" + nombre + "' ya está en uso por una estructura");
            ctx.marcarConflicto(nombre);
            return;
        }
        info = new InfoClase(this, tabla.getClases().size() + 1, ContextoSemantico.paqueteDe(archivo));
        tabla.registrarClase(info);
    }

    private boolean registrada(ContextoSemantico ctx) {
        return info != null && ctx.tabla().buscarClase(nombre) == info;
    }

    /** Enlaza la clase con su superclase (extends). Se hace antes de validar los miembros. */
    public void resolverPadre(ContextoSemantico ctx) {
        if (!registrada(ctx) || nombrePadre == null) return;
        InfoClase padre = ctx.tabla().buscarClase(nombrePadre);
        if (padre == null) {
            ctx.error(this, "La clase '" + nombrePadre + "' que se intenta heredar no existe (¿se importó su archivo .z?)");
            return;
        }
        if (padre.getModificador() == Modificador.PRIVADO
                || padre.getModificador() == Modificador.NINGUNO && !padre.getPaquete().equals(info.getPaquete())) {
            ctx.error(this, "La clase " + nombre + " no puede heredar de " + nombrePadre + ": no es visible desde su paquete");
        }
        for (InfoClase c = padre; c != null; c = c.getPadre()) {
            if (c == info) {
                ctx.error(this, "Herencia cíclica: la clase " + nombre + " termina heredando de sí misma");
                return;
            }
        }
        info.setPadre(padre);
    }

    /// Valida los miembros de la clase: atributos, constructores y métodos. Se hace después de resolver el padre.
    public void validarMiembros(ContextoSemantico ctx) {
        if (!registrada(ctx)) return;
        ctx.tabla().abrir(nombre);
        atributos.forEach(a -> a.validar(ctx, info));
        List<List<Tipo>> firmas = new ArrayList<>();
        constructores.forEach(k -> k.validarFirma(ctx, this, firmas));
        metodos.forEach(m -> m.validarFirma(ctx, info));
        ctx.tabla().cerrar();
        if (constructores.isEmpty()) verificarConstructorPadre(ctx, this);
    }

    public void verificarConstructorPadre(ContextoSemantico ctx, Nodo donde) {
        InfoClase padre = info.getPadre();
        if (InfoClase.tieneConstructores(padre) && InfoClase.constructorImplicito(padre) == null) {
            ctx.error(donde, "La clase " + padre.getNombre() + " no tiene un constructor sin parámetros: "
                    + "el constructor de " + nombre + " debe llamar a super(...)");
        }
    }

    public void analizar(ContextoSemantico ctx) {
        if (!registrada(ctx)) return;
        ctx.setClaseActual(info);
        ctx.setPaqueteActual(info.getPaquete());
        ctx.tabla().abrir(nombre);
        atributos.forEach(a -> a.analizar(ctx));
        constructores.forEach(k -> k.analizar(ctx));
        metodos.forEach(m -> m.analizar(ctx));
        ctx.tabla().cerrar();
        ctx.setClaseActual(null);
    }

    /** true si esta clase o algún ancestro tiene atributos con valor inicial. */
    public boolean requiereInicio() {
        if (atributos.stream().anyMatch(Atributo::tieneValorInicial)) return true;
        return info.getPadre() != null && info.getPadre().getDefinicion().requiereInicio();
    }

    public void nombrar(ContextoC3D ctx) {
        if (requiereInicio()) ctx.nombrar(this, "i_" + nombre);
        for (int i = 0; i < constructores.size(); i++) ctx.nombrar(constructores.get(i), "c_" + nombre + "_" + i);
        for (int i = 0; i < metodos.size(); i++) {
            DefMetodo m = metodos.get(i);
            ctx.nombrar(m, "m_" + nombre + "_" + m.getNombre() + "_" + i);
            if (m.esVirtual()) ctx.nombrarVirtual(m, "v_" + nombre + "_" + m.getNombre() + "_" + i);
        }
    }

    public void generar(ContextoC3D ctx) {
        String inicio = ctx.nombre(this);
        if (inicio != null) {
            ctx.iniciarFuncion(2);
            InfoClase padre = info.getPadre();
            if (padre != null && padre.getDefinicion().requiereInicio()) {
                ctx.usar(ctx.llamar(ctx.nombre(padre.getDefinicion()), List.of(ctx.este())));
                ctx.finInstruccion();
            }
            atributos.forEach(a -> a.generar(ctx));
            ctx.terminarFuncion(inicio);
        }
        constructores.forEach(k -> k.generar(ctx));
        metodos.forEach(m -> m.generar(ctx));
        for (DefMetodo m : metodos) {
            if (m.esVirtual()) ctx.generarDespachador(m);
        }
    }
}
