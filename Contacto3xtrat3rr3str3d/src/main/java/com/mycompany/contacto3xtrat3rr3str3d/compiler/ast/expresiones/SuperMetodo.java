package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefMetodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.ArrayList;
import java.util.List;

public class SuperMetodo extends Expresion {

    private final String metodo;
    private final List<Expresion> argumentos;
    private DefMetodo declaracion;

    public SuperMetodo(Ubicacion ubicacion, String metodo, List<Expresion> argumentos) {
        super(ubicacion);
        this.metodo = metodo;
        this.argumentos = List.copyOf(argumentos);
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        List<Tipo> tipos = ctx.tiposArgumentos(argumentos);
        InfoClase padre = SuperAtributo.padreActual(ctx, this);
        if (padre == null) return resultado(Tipo.ERROR);
        declaracion = ctx.resolverMetodo(padre, metodo, tipos, this);
        if (declaracion == null) return resultado(Tipo.ERROR);
        return resultado(declaracion.getTipoRetorno());
    }

    @Override
    public String generar(ContextoC3D ctx) {
        List<String> valores = new ArrayList<>();
        valores.add(ctx.este());
        for (Expresion a : argumentos) valores.add(a.generar(ctx));
        return ctx.llamar(ctx.nombre(declaracion), valores);
    }
}
