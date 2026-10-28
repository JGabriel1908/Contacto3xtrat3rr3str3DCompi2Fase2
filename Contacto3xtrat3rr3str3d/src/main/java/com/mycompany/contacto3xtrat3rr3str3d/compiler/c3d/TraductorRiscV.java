package com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Traduce las cuartetas a ensamblador RISC-V (RV32IMFD) para el simulador RARS.
 *
 * Igual que en el C intermedio, stack, heap y los temporales guardan valores double:
 * <ul>
 *   <li>s0 = P y s1 = H (enteros), s2 = base del stack, s3 = base del heap, s4 = base de los temporales.</li>
 *   <li>stack, heap y temporales se reservan al iniciar con sbrk; cada posición ocupa 8 bytes.</li>
 *   <li>Cada cuarteta carga sus operandos en ft0/ft1, opera y guarda el resultado.</li>
 *   <li>Las funciones guardan ra en la pila real (sp) para permitir la recursión.</li>
 *   <li>No hay funciones auxiliares: las nativas y las rutinas de entrada/salida se expanden en línea
 *   en cada uso, con sus etiquetas renombradas. Solo las funciones del programa usan jal/ret.</li>
 * </ul>
 */
public final class TraductorRiscV {

    static final int TAMANO_STACK = 150000;
    static final int TAMANO_HEAP = 250000;

    private final StringBuilder sb = new StringBuilder();
    private final Map<String, String> constantes = new LinkedHashMap<>();
    private final int temporales;
    private int saltos;
    // Cada expansión en línea usa un sufijo distinto para sus etiquetas
    private int copias;
    // Dentro de nativa_imprimir_cadena se imprimen bytes UTF-8; en el resto, códigos de carácter completos
    private boolean bytesUtf8;

    private TraductorRiscV(int temporales) {
        this.temporales = temporales;
    }

    public static String programa(ContextoC3D ctx) {
        TraductorRiscV t = new TraductorRiscV(ctx.getTemporales());
        return t.ensamblar(ctx);
    }

    private String ensamblar(ContextoC3D ctx) {
        StringBuilder texto = new StringBuilder();
        linea("# Ensamblador RISC-V generado por Contacto 3xtrat3rr3str3D (ejecutar en RARS)");
        linea(".text");
        linea(".globl main");
        etiqueta("main");
        reservar(TAMANO_STACK, "s2");
        reservar(TAMANO_HEAP, "s3");
        reservar(temporales + Nativas.TEMPORALES, "s4");
        linea("li s0, 0");
        linea("li s1, 1");
        for (Cuarteta c : ctx.getPrincipal()) instruccion(c, false);
        etiqueta("fin_programa");
        linea("li a7, 10");
        linea("ecall");
        texto.append(sb);
        sb.setLength(0);

        for (Map.Entry<String, List<Cuarteta>> f : ctx.getFunciones().entrySet()) funcion(f.getKey(), f.getValue());
        texto.append(sb);

        StringBuilder datos = new StringBuilder("\n.data\n");
        datos.append("buffer_entrada: .space 1024\n");
        datos.append("posicion_entrada: .word 0\n");
        datos.append("utf8_pendientes: .word 0\n");
        datos.append("utf8_codigo: .word 0\n");
        datos.append(".align 3\n");
        for (Map.Entry<String, String> c : constantes.entrySet()) {
            datos.append(c.getValue()).append(": .double ").append(c.getKey()).append('\n');
        }
        return texto.append(datos).toString();
    }

    /** Pide memoria con sbrk (ecall 9) para posiciones de 8 bytes y deja la dirección en el registro. */
    private void reservar(int posiciones, String registro) {
        linea("li a0, " + (posiciones * 8L));
        linea("li a7, 9");
        linea("ecall");
        linea("mv " + registro + ", a0");
    }

    private void funcion(String nombre, List<Cuarteta> cuartetas) {
        sb.append('\n');
        etiqueta(nombre);
        linea("addi sp, sp, -4");
        linea("sw ra, 0(sp)");
        for (Cuarteta c : cuartetas) instruccion(c, true);
        boolean terminaEnRetorno = !cuartetas.isEmpty()
                && cuartetas.get(cuartetas.size() - 1).operador() == Cuarteta.Operador.RETORNO;
        if (!terminaEnRetorno) retorno();
    }

    private void retorno() {
        linea("lw ra, 0(sp)");
        linea("addi sp, sp, 4");
        linea("ret");
    }

    private void instruccion(Cuarteta c, boolean enFuncion) {
        String a = c.arg1();
        String b = c.arg2();
        String r = c.resultado();
        switch (c.operador()) {
            case ETIQUETA -> etiqueta(r);
            case ASIGNACION -> {
                cargar(a, "ft0");
                guardar(r, "ft0");
            }
            case SUMA, RESTA, MULTIPLICACION, DIVISION -> {
                cargar(a, "ft0");
                cargar(b, "ft1");
                String op = switch (c.operador()) {
                    case SUMA -> "fadd.d";
                    case RESTA -> "fsub.d";
                    case MULTIPLICACION -> "fmul.d";
                    default -> "fdiv.d";
                };
                linea(op + " ft0, ft0, ft1");
                guardar(r, "ft0");
            }
            case MODULO -> {
                cargar(a, "ft0");
                cargar(b, "ft1");
                linea("fcvt.w.d t1, ft0, rtz");
                linea("fcvt.w.d t2, ft1, rtz");
                linea("rem t1, t1, t2");
                linea("fcvt.d.w ft0, t1");
                guardar(r, "ft0");
            }
            case MENOR, MAYOR, MENOR_IGUAL, MAYOR_IGUAL, IGUAL, DIFERENTE -> {
                comparar(c.operador().getSimbolo(), a, b);
                linea("fcvt.d.w ft0, t1");
                guardar(r, "ft0");
            }
            case NEGATIVO -> {
                cargar(a, "ft0");
                linea("fneg.d ft0, ft0");
                guardar(r, "ft0");
            }
            case NOT -> {
                cargar(a, "ft0");
                linea("fcvt.d.w ft1, zero");
                linea("feq.d t1, ft0, ft1");
                linea("fcvt.d.w ft0, t1");
                guardar(r, "ft0");
            }
            case TRUNCAR -> {
                cargar(a, "ft0");
                linea("fcvt.w.d t1, ft0, rtz");
                linea("fcvt.d.w ft0, t1");
                guardar(r, "ft0");
            }
            case CARGAR_STACK, CARGAR_HEAP -> {
                direccion(a, c.operador() == Cuarteta.Operador.CARGAR_STACK ? "s2" : "s3");
                linea("fld ft0, 0(t2)");
                guardar(r, "ft0");
            }
            case GUARDAR_STACK, GUARDAR_HEAP -> {
                direccion(r, c.operador() == Cuarteta.Operador.GUARDAR_STACK ? "s2" : "s3");
                cargar(a, "ft0");
                linea("fsd ft0, 0(t2)");
            }
            case SALTO -> linea("j " + r);
            case SI_IGUAL, SI_DIFERENTE, SI_MENOR, SI_MAYOR, SI_MENOR_IGUAL, SI_MAYOR_IGUAL -> {
                comparar(c.operador().getSimbolo(), a, b);
                // beqz solo alcanza ±4 KB: se salta sobre un j, que alcanza ±1 MB
                String sigue = "sigue_" + (++saltos);
                linea("beqz t1, " + sigue);
                linea("j " + r);
                etiqueta(sigue);
            }
            case LLAMADA -> {
                if (Nativas.esNativa(a)) expandirNativa(a, enFuncion);
                else linea("jal ra, " + a);
            }
            case RETORNO -> {
                if (enFuncion) retorno();
                else linea("j fin_programa");
            }
            case IMPRIMIR_ENTERO -> {
                cargar(a, "ft0");
                linea("fcvt.w.d a0, ft0, rtz");
                linea("li a7, 1");
                linea("ecall");
            }
            case IMPRIMIR_CARACTER -> {
                cargar(a, "ft0");
                linea("fcvt.w.d a0, ft0, rtz");
                if (bytesUtf8) {
                    rutina(IMPRIMIR_BYTE);
                } else {
                    linea("li a7, 11");
                    linea("ecall");
                }
            }
            case LEER_CARACTER -> {
                rutina(LEER_CARACTER);
                linea("fcvt.d.w ft0, a0");
                guardar(r, "ft0");
            }
        }
    }

    /**
     * Copia aquí el cuerpo de la nativa: sus etiquetas llevan un sufijo propio de esta copia y cada
     * return salta al final de la copia en lugar de volver con ret.
     */
    private void expandirNativa(String nombre, boolean enFuncion) {
        String sufijo = "_" + (++copias);
        String fin = "fin_" + nombre + sufijo;
        boolean anterior = bytesUtf8;
        bytesUtf8 = nombre.equals(Nativas.IMPRIMIR_CADENA);
        linea("# " + nombre + " (en línea)");
        for (Cuarteta c : Nativas.cuartetas(nombre)) {
            switch (c.operador()) {
                case RETORNO -> linea("j " + fin);
                case ETIQUETA, SALTO, SI_IGUAL, SI_DIFERENTE, SI_MENOR, SI_MAYOR, SI_MENOR_IGUAL, SI_MAYOR_IGUAL ->
                        instruccion(new Cuarteta(c.operador(), c.arg1(), c.arg2(), c.resultado() + sufijo), enFuncion);
                default -> instruccion(c, enFuncion);
            }
        }
        etiqueta(fin);
        bytesUtf8 = anterior;
    }

    /** Copia aquí una rutina de entrada/salida; "@" en sus etiquetas se cambia por un sufijo único. */
    private void rutina(String plantilla) {
        sb.append(plantilla.replace("@", "_" + (++copias)));
    }

    /** Compara a y b (double) y deja 1 o 0 en t1. */
    private void comparar(String simbolo, String a, String b) {
        cargar(a, "ft0");
        cargar(b, "ft1");
        switch (simbolo) {
            case "<" -> linea("flt.d t1, ft0, ft1");
            case ">" -> linea("flt.d t1, ft1, ft0");
            case "<=" -> linea("fle.d t1, ft0, ft1");
            case ">=" -> linea("fle.d t1, ft1, ft0");
            case "==" -> linea("feq.d t1, ft0, ft1");
            default -> {
                linea("feq.d t1, ft0, ft1");
                linea("xori t1, t1, 1");
            }
        }
    }

    /** Deja en t2 la dirección de memoria[(int) indice]; base es s2 (stack) o s3 (heap). */
    private void direccion(String indice, String base) {
        switch (indice) {
            case "P" -> linea("slli t2, s0, 3");
            case "H" -> linea("slli t2, s1, 3");
            default -> {
                if (esEntero(indice)) {
                    linea("li t2, " + (Long.parseLong(indice) * 8));
                } else {
                    cargar(indice, "ft2");
                    linea("fcvt.w.d t2, ft2, rtz");
                    linea("slli t2, t2, 3");
                }
            }
        }
        linea("add t2, " + base + ", t2");
    }

    private void cargar(String valor, String registro) {
        switch (valor) {
            case "P" -> linea("fcvt.d.w " + registro + ", s0");
            case "H" -> linea("fcvt.d.w " + registro + ", s1");
            default -> {
                if (esTemporal(valor)) {
                    direccionTemporal(valor);
                    linea("fld " + registro + ", 0(t0)");
                } else if (esEntero(valor)) {
                    linea("li t0, " + valor);
                    linea("fcvt.d.w " + registro + ", t0");
                } else {
                    String etiqueta = constantes.computeIfAbsent(String.valueOf(Double.parseDouble(valor)),
                            k -> "constante_" + constantes.size());
                    linea("la t0, " + etiqueta);
                    linea("fld " + registro + ", 0(t0)");
                }
            }
        }
    }

    private void guardar(String destino, String registro) {
        switch (destino) {
            case "P" -> linea("fcvt.w.d s0, " + registro + ", rtz");
            case "H" -> linea("fcvt.w.d s1, " + registro + ", rtz");
            default -> {
                direccionTemporal(destino);
                linea("fsd " + registro + ", 0(t0)");
            }
        }
    }

    /** Los temporales t1..tN van primero y los de las nativas n1..n8 después. */
    private void direccionTemporal(String nombre) {
        int numero = Integer.parseInt(nombre.substring(1));
        int posicion = nombre.charAt(0) == 't' ? numero - 1 : temporales + numero - 1;
        int desplazamiento = posicion * 8;
        if (desplazamiento < 2048) {
            linea("addi t0, s4, " + desplazamiento);
        } else {
            linea("li t0, " + desplazamiento);
            linea("add t0, s4, t0");
        }
    }

    private static boolean esTemporal(String valor) {
        return valor.length() > 1 && (valor.charAt(0) == 't' || valor.charAt(0) == 'n')
                && valor.substring(1).chars().allMatch(Character::isDigit);
    }

    private static boolean esEntero(String valor) {
        if (!valor.matches("-?\\d{1,10}")) return false;
        long v = Long.parseLong(valor);
        return v >= Integer.MIN_VALUE && v <= Integer.MAX_VALUE;
    }

    private void etiqueta(String nombre) {
        sb.append(nombre).append(":\n");
    }

    private void linea(String instruccion) {
        sb.append("    ").append(instruccion).append('\n');
    }

    /**
     * Rutinas de entrada/salida sobre las llamadas al sistema de RARS, para expandir en línea:
     * <ul>
     *   <li>IMPRIMIR_BYTE recibe en a0 los bytes UTF-8 de las cadenas y los junta en un carácter
     *   antes de imprimirlo (ecall 11), para que las tildes y la ñ se vean bien.</li>
     *   <li>LEER_CARACTER deja en a0 el siguiente carácter de la entrada (o -1 al terminar);
     *   lee línea por línea con ecall 8 porque ecall 12 no acepta el salto de línea.</li>
     * </ul>
     */
    private static final String IMPRIMIR_BYTE = """
                la t3, utf8_pendientes
                lw t4, 0(t3)
                la t5, utf8_codigo
                bnez t4, ib_continuacion@
                li t6, 128
                blt a0, t6, ib_imprimir@
                li t6, 240
                bge a0, t6, ib_cuatro@
                li t6, 224
                bge a0, t6, ib_tres@
                andi a0, a0, 31
                li t4, 1
                j ib_guardar@
            ib_tres@:
                andi a0, a0, 15
                li t4, 2
                j ib_guardar@
            ib_cuatro@:
                andi a0, a0, 7
                li t4, 3
            ib_guardar@:
                sw t4, 0(t3)
                sw a0, 0(t5)
                j ib_fin@
            ib_continuacion@:
                lw t6, 0(t5)
                slli t6, t6, 6
                andi a0, a0, 63
                or a0, t6, a0
                addi t4, t4, -1
                sw t4, 0(t3)
                sw a0, 0(t5)
                bnez t4, ib_fin@
            ib_imprimir@:
                li a7, 11
                ecall
            ib_fin@:
            """;

    private static final String LEER_CARACTER = """
                la t3, posicion_entrada
                lw t4, 0(t3)
                la t5, buffer_entrada
                add t6, t5, t4
                lbu a0, 0(t6)
                bnez a0, lc_devolver@
                mv a0, t5
                li a1, 1024
                li a7, 8
                ecall
                li t4, 0
                lbu a0, 0(t5)
                bnez a0, lc_devolver@
                sb zero, 0(t5)
                li a0, -1
                j lc_fin@
            lc_devolver@:
                addi t4, t4, 1
                sw t4, 0(t3)
                add t6, t5, t4
                lbu t6, 0(t6)
                bnez t6, lc_fin@
                sw zero, 0(t3)
                sb zero, 0(t5)
            lc_fin@:
            """;
}
