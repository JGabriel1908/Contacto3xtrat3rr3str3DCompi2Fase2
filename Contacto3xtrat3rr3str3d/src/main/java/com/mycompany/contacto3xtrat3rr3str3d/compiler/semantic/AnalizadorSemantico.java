package com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ErrorCompilacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Programa;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Unidad;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.UnidadY;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.UnidadZetariano;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoEstructura;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.TablaSimbolos;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public final class AnalizadorSemantico {

    public record Resultado(List<ErrorCompilacion> errores, TablaSimbolos tabla) {
    }

    private AnalizadorSemantico() {
    }

    public static Resultado analizar(Nodo raiz) {
        ContextoSemantico ctx = new ContextoSemantico();
        List<Unidad> unidades = raiz instanceof Programa p ? p.getUnidades() : List.of((Unidad) raiz);

        for (Unidad u : unidades) if (u instanceof UnidadY y) y.registrarEstructuras(ctx);
        for (Unidad u : unidades) if (u instanceof UnidadZetariano z) z.registrar(ctx);
        for (Unidad u : unidades) if (u instanceof UnidadY y) y.registrarFunciones(ctx);

        for (Unidad u : unidades) if (u instanceof UnidadY y) y.validarEstructuras(ctx);
        for (InfoEstructura e : ctx.getEstructurasGlobales()) e.getDefinicion().verificarCiclo(ctx, e);
        for (Unidad u : unidades) if (u instanceof UnidadY y) y.validarFunciones(ctx);
        for (Unidad u : unidades) if (u instanceof UnidadZetariano z) z.getClase().resolverPadre(ctx);
        // Los padres se validan antes que sus hijas: sus atributos y métodos deben existir para heredarlos
        List<InfoClase> clases = new ArrayList<>(ctx.tabla().getClases());
        clases.sort(Comparator.comparingInt(InfoClase::profundidad));
        for (InfoClase c : clases) c.getDefinicion().validarMiembros(ctx);

        for (Unidad u : unidades) {
            ctx.setPaqueteActual(ContextoSemantico.paqueteDe(u.getArchivo()));
            u.analizar(ctx);
        }

        List<ErrorCompilacion> errores = ctx.getErrores();
        errores.sort(Comparator.comparing(ErrorCompilacion::archivo)
                .thenComparingInt(ErrorCompilacion::linea)
                .thenComparingInt(ErrorCompilacion::columna));
        return new Resultado(errores, ctx.tabla());
    }
}
