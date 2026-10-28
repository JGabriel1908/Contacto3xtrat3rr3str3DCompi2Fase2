#!/usr/bin/env bash
# Ejecuta en RARS (sin interfaz gráfica) un programa RISC-V generado por Contacto 3xtrat3rr3str3D.
# Uso: ./ejecutar.sh [archivo.asm]          (por defecto main.asm)
# rars.jar se toma de la variable RARS_JAR o se busca (rars*.jar) en esta carpeta, en lib/
# y en las carpetas superiores. Se descarga de https://github.com/TheThirdOne/rars/releases

ASM="${1:-main.asm}"
if [ ! -f "$ASM" ]; then
    echo "No existe el archivo $ASM" >&2
    exit 1
fi

JAR="$RARS_JAR"
if [ -z "$JAR" ] || [ ! -f "$JAR" ]; then
    JAR=""
    DIR="$(cd "$(dirname "$0")" && pwd)"
    while [ -z "$JAR" ]; do
        JAR="$(ls "$DIR"/rars*.jar "$DIR"/lib/rars*.jar 2> /dev/null | head -n 1)"
        [ "$DIR" = "/" ] && break
        DIR="$(dirname "$DIR")"
    done
fi
if [ -z "$JAR" ]; then
    echo "No se encontró rars.jar. Descárgalo de https://github.com/TheThirdOne/rars/releases" >&2
    echo "y ponlo en esta carpeta, en lib/ o indica su ruta en la variable RARS_JAR." >&2
    exit 1
fi

# nc: sin aviso de copyright, me: mensajes de RARS a stderr
exec java -jar "$JAR" nc me "$ASM"
