package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.Atributo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Cuarteta.Operador;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Direccion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

public class SuperAtributo extends Expresion {

    private final String atributo;
    private Simbolo simbolo;

    public SuperAtributo(Ubicacion ubicacion, String atributo) {
        super(ubicacion);
        this.atributo = atributo;
    }

    static InfoClase padreActual(ContextoSemantico ctx, Nodo donde) {
        InfoClase clase = ctx.getClaseActual();
        if (clase == null) {
            ctx.error(donde, "'super' solo puede usarse dentro de una clase");
            return null;
        }
        if (clase.getPadre() == null) {
            ctx.error(donde, "La clase " + clase.getNombre() + " no hereda de ninguna clase: no puede usar 'super'");
        }
        return clase.getPadre();
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        InfoClase padre = padreActual(ctx, this);
        if (padre == null) return resultado(Tipo.ERROR);
        Simbolo s = padre.getAtributo(atributo);
        if (s == null) {
            ctx.error(this, "La clase " + padre.getNombre() + " no tiene un atributo '" + atributo + "'");
            return resultado(Tipo.ERROR);
        }
        Atributo a = (Atributo) s.getDeclaracion();
        ctx.verificarAcceso(this, a.getModificador(), a.getClase(), "El atributo '" + atributo + "'");
        simbolo = s;
        return resultado(s.getTipo());
    }

    @Override
    public boolean esAsignable() {
        return true;
    }

    @Override
    public String generar(ContextoC3D ctx) {
        return ctx.cargar(direccion(ctx));
    }

    @Override
    public Direccion direccion(ContextoC3D ctx) {
        String posicion = ctx.operar(Operador.SUMA, ctx.este(), String.valueOf(simbolo.getDesplazamiento()));
        return new Direccion(Direccion.HEAP, posicion);
    }
}
