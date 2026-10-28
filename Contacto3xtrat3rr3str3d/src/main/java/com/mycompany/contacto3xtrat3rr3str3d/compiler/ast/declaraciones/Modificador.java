package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

//Modificador para el zetariano
public enum Modificador {
    PUBLICO("public", 3),
    PRIVADO("private", 0),
    PROTEGIDO("protected", 2),
    NINGUNO("", 1);

    private final String palabra;
    private final int apertura;

    Modificador(String palabra, int apertura) {
        this.palabra = palabra;
        this.apertura = apertura;
    }

    public boolean masRestrictivoQue(Modificador otro) {
        return apertura < otro.apertura;
    }

    public String descripcion() {
        return this == NINGUNO ? "de paquete (sin modificador)" : palabra;
    }

    @Override
    public String toString() {
        return palabra;
    }
}
