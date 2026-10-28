package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefConstructor;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.ArrayList;
import java.util.List;

public class SuperConstructor extends Expresion {

    private final List<Expresion> argumentos;
    private DefConstructor constructor;

    public SuperConstructor(Ubicacion ubicacion, List<Expresion> argumentos) {
        super(ubicacion);
        this.argumentos = List.copyOf(argumentos);
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        List<Tipo> tipos = ctx.tiposArgumentos(argumentos);
        InfoClase clase = ctx.getClaseActual();
        if (clase == null || !ctx.isEnConstructor()) {
            ctx.error(this, "super(...) solo puede usarse dentro de un constructor");
            return resultado(Tipo.ERROR);
        }
        InfoClase padre = clase.getPadre();
        if (padre == null) {
            ctx.error(this, "La clase " + clase.getNombre() + " no hereda de ninguna clase: no puede llamar a super(...)");
            return resultado(Tipo.ERROR);
        }
        if (padre.getConstructores().isEmpty()) {
            // El padre solo tiene el constructor por defecto: se ejecuta el implícito de su cadena
            if (!tipos.isEmpty()) ctx.error(this, "La clase " + padre.getNombre() + " no tiene un constructor con parámetros");
            constructor = InfoClase.constructorImplicito(padre);
            return resultado(Tipo.VACIO);
        }
        constructor = ctx.resolverConstructor(padre, tipos, this);
        return resultado(Tipo.VACIO);
    }

    @Override
    public String generar(ContextoC3D ctx) {
        if (constructor == null) return "0";
        List<String> valores = new ArrayList<>();
        valores.add(ctx.este());
        for (Expresion a : argumentos) valores.add(a.generar(ctx));
        return ctx.llamar(ctx.nombre(constructor), valores);
    }
}
