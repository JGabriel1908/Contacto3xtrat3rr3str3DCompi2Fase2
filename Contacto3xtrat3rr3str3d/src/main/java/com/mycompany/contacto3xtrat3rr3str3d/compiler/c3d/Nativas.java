package com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Cuarteta.Operador;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class Nativas {

    public static final String IMPRIMIR_CADENA = "nativa_imprimir_cadena";
    public static final String CONCATENAR = "nativa_concatenar";
    public static final String ENTERO_A_CADENA = "nativa_entero_a_cadena";
    public static final String DECIMAL_A_CADENA = "nativa_decimal_a_cadena";
    public static final String LEER_CADENA = "nativa_leer_cadena";
    public static final String CADENA_A_ENTERO = "nativa_cadena_a_entero";
    public static final String CADENA_A_DECIMAL = "nativa_cadena_a_decimal";
    public static final String COMPARAR_CADENAS = "nativa_comparar_cadenas";
    public static final String COPIAR = "nativa_copiar";

    public static final int TEMPORALES = 8;

    private static final Map<String, String> CODIGO = new LinkedHashMap<>();

    static {
        CODIGO.put(IMPRIMIR_CADENA, """
                void nativa_imprimir_cadena() {
                    n1 = P + 1;
                    n2 = stack[(int) n1];
                L_ic_1:
                    n3 = heap[(int) n2];
                    if (n3 == 0) goto L_ic_2;
                    printf("%c", (int) n3);
                    n2 = n2 + 1;
                    goto L_ic_1;
                L_ic_2:
                    return;
                }
                """);
        CODIGO.put(CONCATENAR, """
                void nativa_concatenar() {
                    n1 = P + 1;
                    n2 = stack[(int) n1];
                    n1 = P + 2;
                    n3 = stack[(int) n1];
                    n4 = H;
                L_cc_1:
                    n5 = heap[(int) n2];
                    if (n5 == 0) goto L_cc_2;
                    heap[H] = n5;
                    H = H + 1;
                    n2 = n2 + 1;
                    goto L_cc_1;
                L_cc_2:
                    n5 = heap[(int) n3];
                    if (n5 == 0) goto L_cc_3;
                    heap[H] = n5;
                    H = H + 1;
                    n3 = n3 + 1;
                    goto L_cc_2;
                L_cc_3:
                    heap[H] = 0;
                    H = H + 1;
                    stack[P] = n4;
                    return;
                }
                """);
        CODIGO.put(ENTERO_A_CADENA, """
                void nativa_entero_a_cadena() {
                    n1 = P + 1;
                    n2 = stack[(int) n1];
                    n3 = H;
                    if (n2 >= 0) goto L_ec_1;
                    heap[H] = 45;
                    H = H + 1;
                    n2 = 0 - n2;
                L_ec_1:
                    n4 = 1;
                L_ec_2:
                    n5 = n2 / n4;
                    n5 = (int) n5;
                    if (n5 < 10) goto L_ec_3;
                    n4 = n4 * 10;
                    goto L_ec_2;
                L_ec_3:
                    n5 = n2 / n4;
                    n5 = (int) n5;
                    n6 = n5 + 48;
                    heap[H] = n6;
                    H = H + 1;
                    n6 = n5 * n4;
                    n2 = n2 - n6;
                    n4 = n4 / 10;
                    n4 = (int) n4;
                    if (n4 >= 1) goto L_ec_3;
                    heap[H] = 0;
                    H = H + 1;
                    stack[P] = n3;
                    return;
                }
                """);
        CODIGO.put(DECIMAL_A_CADENA, """
                void nativa_decimal_a_cadena() {
                    n1 = P + 1;
                    n2 = stack[(int) n1];
                    n3 = H;
                    if (n2 >= 0) goto L_dc_1;
                    heap[H] = 45;
                    H = H + 1;
                    n2 = 0 - n2;
                L_dc_1:
                    n7 = (int) n2;
                    n8 = n2 - n7;
                    n8 = n8 * 1000000;
                    n8 = n8 + 0.5;
                    n8 = (int) n8;
                    if (n8 < 1000000) goto L_dc_2;
                    n7 = n7 + 1;
                    n8 = n8 - 1000000;
                L_dc_2:
                    n4 = 1;
                L_dc_3:
                    n5 = n7 / n4;
                    n5 = (int) n5;
                    if (n5 < 10) goto L_dc_4;
                    n4 = n4 * 10;
                    goto L_dc_3;
                L_dc_4:
                    n5 = n7 / n4;
                    n5 = (int) n5;
                    n6 = n5 + 48;
                    heap[H] = n6;
                    H = H + 1;
                    n6 = n5 * n4;
                    n7 = n7 - n6;
                    n4 = n4 / 10;
                    n4 = (int) n4;
                    if (n4 >= 1) goto L_dc_4;
                    heap[H] = 46;
                    H = H + 1;
                    n4 = 100000;
                L_dc_5:
                    n5 = n8 / n4;
                    n5 = (int) n5;
                    n6 = n5 + 48;
                    heap[H] = n6;
                    H = H + 1;
                    n6 = n5 * n4;
                    n8 = n8 - n6;
                    n4 = n4 / 10;
                    n4 = (int) n4;
                    if (n4 >= 1) goto L_dc_5;
                L_dc_6:
                    n5 = H - 1;
                    n6 = heap[(int) n5];
                    if (n6 != 48) goto L_dc_7;
                    n5 = H - 2;
                    n6 = heap[(int) n5];
                    if (n6 == 46) goto L_dc_7;
                    H = H - 1;
                    goto L_dc_6;
                L_dc_7:
                    heap[H] = 0;
                    H = H + 1;
                    stack[P] = n3;
                    return;
                }
                """);
        CODIGO.put(LEER_CADENA, """
                void nativa_leer_cadena() {
                    n1 = H;
                L_lc_1:
                    n2 = getchar();
                    if (n2 == 10) goto L_lc_2;
                    if (n2 == -1) goto L_lc_2;
                    if (n2 == 13) goto L_lc_1;
                    heap[H] = n2;
                    H = H + 1;
                    goto L_lc_1;
                L_lc_2:
                    heap[H] = 0;
                    H = H + 1;
                    stack[P] = n1;
                    return;
                }
                """);
        CODIGO.put(CADENA_A_ENTERO, """
                void nativa_cadena_a_entero() {
                    n1 = P + 1;
                    n2 = stack[(int) n1];
                    n3 = 0;
                    n4 = 1;
                L_ce_0:
                    n5 = heap[(int) n2];
                    if (n5 != 32) goto L_ce_1;
                    n2 = n2 + 1;
                    goto L_ce_0;
                L_ce_1:
                    if (n5 != 45) goto L_ce_2;
                    n4 = -1;
                    n2 = n2 + 1;
                L_ce_2:
                    n5 = heap[(int) n2];
                    if (n5 < 48) goto L_ce_3;
                    if (n5 > 57) goto L_ce_3;
                    n3 = n3 * 10;
                    n6 = n5 - 48;
                    n3 = n3 + n6;
                    n2 = n2 + 1;
                    goto L_ce_2;
                L_ce_3:
                    n3 = n3 * n4;
                    stack[P] = n3;
                    return;
                }
                """);
        CODIGO.put(CADENA_A_DECIMAL, """
                void nativa_cadena_a_decimal() {
                    n1 = P + 1;
                    n2 = stack[(int) n1];
                    n3 = 0;
                    n4 = 1;
                L_cd_0:
                    n5 = heap[(int) n2];
                    if (n5 != 32) goto L_cd_1;
                    n2 = n2 + 1;
                    goto L_cd_0;
                L_cd_1:
                    if (n5 != 45) goto L_cd_2;
                    n4 = -1;
                    n2 = n2 + 1;
                L_cd_2:
                    n5 = heap[(int) n2];
                    if (n5 < 48) goto L_cd_3;
                    if (n5 > 57) goto L_cd_3;
                    n3 = n3 * 10;
                    n6 = n5 - 48;
                    n3 = n3 + n6;
                    n2 = n2 + 1;
                    goto L_cd_2;
                L_cd_3:
                    if (n5 != 46) goto L_cd_5;
                    n2 = n2 + 1;
                    n7 = 0.1;
                L_cd_4:
                    n5 = heap[(int) n2];
                    if (n5 < 48) goto L_cd_5;
                    if (n5 > 57) goto L_cd_5;
                    n6 = n5 - 48;
                    n6 = n6 * n7;
                    n3 = n3 + n6;
                    n7 = n7 / 10;
                    n2 = n2 + 1;
                    goto L_cd_4;
                L_cd_5:
                    n3 = n3 * n4;
                    stack[P] = n3;
                    return;
                }
                """);
        CODIGO.put(COMPARAR_CADENAS, """
                void nativa_comparar_cadenas() {
                    n1 = P + 1;
                    n2 = stack[(int) n1];
                    n1 = P + 2;
                    n3 = stack[(int) n1];
                L_cm_1:
                    n4 = heap[(int) n2];
                    n5 = heap[(int) n3];
                    if (n4 != n5) goto L_cm_3;
                    if (n4 == 0) goto L_cm_2;
                    n2 = n2 + 1;
                    n3 = n3 + 1;
                    goto L_cm_1;
                L_cm_2:
                    stack[P] = 1;
                    return;
                L_cm_3:
                    stack[P] = 0;
                    return;
                }
                """);
        CODIGO.put(COPIAR, """
                void nativa_copiar() {
                    n1 = P + 1;
                    n2 = stack[(int) n1];
                    n1 = P + 2;
                    n3 = stack[(int) n1];
                    n1 = P + 3;
                    n4 = stack[(int) n1];
                L_cp_1:
                    if (n4 <= 0) goto L_cp_2;
                    n5 = heap[(int) n3];
                    heap[(int) n2] = n5;
                    n2 = n2 + 1;
                    n3 = n3 + 1;
                    n4 = n4 - 1;
                    goto L_cp_1;
                L_cp_2:
                    return;
                }
                """);
    }

    private static final Pattern ETIQUETA = Pattern.compile("(\\w+):");
    private static final Pattern SALTO = Pattern.compile("goto (\\w+);");
    private static final Pattern SI = Pattern.compile("if \\((\\S+) (==|!=|<=|>=|<|>) (\\S+)\\) goto (\\w+);");
    private static final Pattern GUARDAR = Pattern.compile("(stack|heap)\\[(?:\\(int\\) )?(\\w+)] = (\\S+);");
    private static final Pattern CARGAR = Pattern.compile("(\\w+) = (stack|heap)\\[\\(int\\) (\\w+)];");
    private static final Pattern TRUNCAR = Pattern.compile("(\\w+) = \\(int\\) (\\S+);");
    private static final Pattern OPERACION = Pattern.compile("(\\w+) = (\\S+) ([-+*/]) (\\S+);");
    private static final Pattern GETCHAR = Pattern.compile("(\\w+) = getchar\\(\\);");
    private static final Pattern ASIGNACION = Pattern.compile("(\\w+) = (\\S+);");
    private static final Pattern PRINTF = Pattern.compile("printf\\(\"%c\", \\(int\\) (\\w+)\\);");
    private static final Map<String, Operador> SALTOS = Map.of("==", Operador.SI_IGUAL, "!=", Operador.SI_DIFERENTE,
            "<", Operador.SI_MENOR, ">", Operador.SI_MAYOR, "<=", Operador.SI_MENOR_IGUAL, ">=", Operador.SI_MAYOR_IGUAL);
    private static final Map<String, Operador> ARITMETICOS = Map.of("+", Operador.SUMA, "-", Operador.RESTA,
            "*", Operador.MULTIPLICACION, "/", Operador.DIVISION);

    private Nativas() {
    }

    /**
     * Las nativas están escritas en el mismo C de tres direcciones que genera el compilador; aquí se
     * convierten de vuelta a cuartetas para que otros traductores (RISC-V) usen exactamente la misma lógica.
     */
    public static List<Cuarteta> cuartetas(String nombre) {
        List<Cuarteta> resultado = new ArrayList<>();
        for (String linea : CODIGO.get(nombre).split("\n")) {
            String l = linea.strip();
            if (l.isEmpty() || l.startsWith("void ") || l.equals("}")) continue;
            Matcher m;
            if ((m = ETIQUETA.matcher(l)).matches()) {
                resultado.add(new Cuarteta(Operador.ETIQUETA, null, null, m.group(1)));
            } else if ((m = SALTO.matcher(l)).matches()) {
                resultado.add(new Cuarteta(Operador.SALTO, null, null, m.group(1)));
            } else if ((m = SI.matcher(l)).matches()) {
                resultado.add(new Cuarteta(SALTOS.get(m.group(2)), m.group(1), m.group(3), m.group(4)));
            } else if ((m = GUARDAR.matcher(l)).matches()) {
                Operador op = m.group(1).equals("stack") ? Operador.GUARDAR_STACK : Operador.GUARDAR_HEAP;
                resultado.add(new Cuarteta(op, m.group(3), null, m.group(2)));
            } else if ((m = CARGAR.matcher(l)).matches()) {
                Operador op = m.group(2).equals("stack") ? Operador.CARGAR_STACK : Operador.CARGAR_HEAP;
                resultado.add(new Cuarteta(op, m.group(3), null, m.group(1)));
            } else if ((m = TRUNCAR.matcher(l)).matches()) {
                resultado.add(new Cuarteta(Operador.TRUNCAR, m.group(2), null, m.group(1)));
            } else if ((m = OPERACION.matcher(l)).matches()) {
                resultado.add(new Cuarteta(ARITMETICOS.get(m.group(3)), m.group(2), m.group(4), m.group(1)));
            } else if ((m = GETCHAR.matcher(l)).matches()) {
                resultado.add(new Cuarteta(Operador.LEER_CARACTER, null, null, m.group(1)));
            } else if ((m = ASIGNACION.matcher(l)).matches()) {
                resultado.add(new Cuarteta(Operador.ASIGNACION, m.group(2), null, m.group(1)));
            } else if ((m = PRINTF.matcher(l)).matches()) {
                resultado.add(new Cuarteta(Operador.IMPRIMIR_CARACTER, m.group(1), null, null));
            } else if (l.equals("return;")) {
                resultado.add(new Cuarteta(Operador.RETORNO, null, null, null));
            } else {
                throw new IllegalStateException("Instrucción nativa no reconocida en " + nombre + ": " + l);
            }
        }
        return resultado;
    }

    public static boolean esNativa(String nombre) {
        return CODIGO.containsKey(nombre);
    }

    public static String codigo(String nombre) {
        return CODIGO.get(nombre);
    }

    /** Nombres en el orden en que se escriben en el archivo. */
    public static Iterable<String> nombres() {
        return CODIGO.keySet();
    }
}
