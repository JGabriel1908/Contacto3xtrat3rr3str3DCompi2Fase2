package com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefConstructor;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefMetodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.Modificador;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase registrada: atributos, constructores y métodos (agrupados por nombre por la sobrecarga).
 * Un objeto en el heap es [identificador de clase, atributos heredados..., atributos propios...];
 * el identificador permite elegir en tiempo de ejecución el método sobrescrito (polimorfismo).
 */
public class InfoClase {

    private final DefClase definicion;
    private final int identificador;
    private final String paquete;
    private InfoClase padre;
    private final Map<String, Simbolo> atributos = new LinkedHashMap<>();
    private final Map<String, List<DefMetodo>> metodos = new LinkedHashMap<>();

    public InfoClase(DefClase definicion, int identificador, String paquete) {
        this.definicion = definicion;
        this.identificador = identificador;
        this.paquete = paquete;
    }

    public String getNombre() {
        return definicion.getNombre();
    }

    public DefClase getDefinicion() {
        return definicion;
    }

    public Modificador getModificador() {
        return definicion.getModificador();
    }

    public int getIdentificador() {
        return identificador;
    }

    /** Carpeta del archivo .z: las clases de la misma carpeta forman un paquete. */
    public String getPaquete() {
        return paquete;
    }

    public InfoClase getPadre() {
        return padre;
    }

    public void setPadre(InfoClase padre) {
        this.padre = padre;
    }

    public int profundidad() {
        return padre == null ? 0 : padre.profundidad() + 1;
    }

    /** Busca el atributo en la clase y luego en sus ancestros. */
    public Simbolo getAtributo(String nombre) {
        Simbolo s = atributos.get(nombre);
        if (s == null && padre != null) return padre.getAtributo(nombre);
        return s;
    }

    /** Posiciones que ocupa un objeto: el identificador de clase más todos los atributos. */
    public int getTamano() {
        return (padre == null ? 1 : padre.getTamano()) + atributos.size();
    }

    public boolean agregarAtributo(Simbolo atributo) {
        return atributos.putIfAbsent(atributo.getNombre(), atributo) == null;
    }

    public List<DefConstructor> getConstructores() {
        return definicion.getConstructores();
    }

    /** Métodos con ese nombre visibles en la clase: los propios y los heredados que no se sobrescribieron. */
    public List<DefMetodo> getMetodos(String nombre) {
        List<DefMetodo> resultado = new ArrayList<>(getMetodosPropios(nombre));
        if (padre == null) return resultado;
        for (DefMetodo heredado : padre.getMetodos(nombre)) {
            boolean sobrescrito = resultado.stream().anyMatch(m -> ContextoSemantico.firma(m.getParametros())
                    .equals(ContextoSemantico.firma(heredado.getParametros())));
            if (!sobrescrito) resultado.add(heredado);
        }
        return resultado;
    }

    public List<DefMetodo> getMetodosPropios(String nombre) {
        return metodos.getOrDefault(nombre, List.of());
    }

    public Collection<List<DefMetodo>> getTodosLosMetodosPropios() {
        return metodos.values();
    }

    public void agregarMetodo(DefMetodo metodo) {
        metodos.computeIfAbsent(metodo.getNombre(), k -> new ArrayList<>()).add(metodo);
    }

    public boolean heredaDe(InfoClase otra) {
        for (InfoClase c = this; c != null; c = c.padre) {
            if (c == otra) return true;
        }
        return false;
    }

    /**
     * Constructor que se ejecuta cuando no se llama a uno explícitamente (new sin argumentos o un constructor
     * hijo sin super(...)): el constructor sin parámetros de la clase más cercana que declare constructores.
     * Devuelve null si ninguna clase de la cadena declara constructores.
     */
    public static DefConstructor constructorImplicito(InfoClase clase) {
        for (InfoClase c = clase; c != null; c = c.padre) {
            if (c.getConstructores().isEmpty()) continue;
            return c.getConstructores().stream().filter(k -> k.getParametros().isEmpty()).findFirst().orElse(null);
        }
        return null;
    }

    /** true si alguna clase de la cadena (desde clase hacia arriba) declara constructores. */
    public static boolean tieneConstructores(InfoClase clase) {
        for (InfoClase c = clase; c != null; c = c.padre) {
            if (!c.getConstructores().isEmpty()) return true;
        }
        return false;
    }
}
