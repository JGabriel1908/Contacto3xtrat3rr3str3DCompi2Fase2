@echo off
rem Ejecuta en RARS (sin interfaz grafica) un programa RISC-V generado por Contacto 3xtrat3rr3str3D.
rem Uso: ejecutar.bat [archivo.asm]          (por defecto main.asm)
rem rars.jar se toma de la variable RARS_JAR o se busca (rars*.jar) en esta carpeta, en lib\
rem y en las carpetas superiores. Se descarga de https://github.com/TheThirdOne/rars/releases
setlocal enabledelayedexpansion

set "ASM=%~1"
if "%ASM%"=="" set "ASM=main.asm"
if not exist "%ASM%" (
    echo No existe el archivo %ASM% 1>&2
    exit /b 1
)

set "JAR="
if defined RARS_JAR if exist "%RARS_JAR%" set "JAR=%RARS_JAR%"
set "DIR=%~dp0"
:buscar
if defined JAR goto ejecutar
for %%F in ("%DIR%rars*.jar" "%DIR%lib\rars*.jar") do if not defined JAR set "JAR=%%~fF"
if defined JAR goto ejecutar
for %%P in ("%DIR%..") do set "PADRE=%%~fP\"
if /i "%PADRE%"=="%DIR%" goto noencontrado
set "DIR=%PADRE%"
goto buscar

:noencontrado
echo No se encontro rars.jar. Descargalo de https://github.com/TheThirdOne/rars/releases 1>&2
echo y ponlo en esta carpeta, en lib\ o indica su ruta en la variable RARS_JAR. 1>&2
exit /b 1

:ejecutar
rem nc: sin aviso de copyright, me: mensajes de RARS a stderr
java -jar "%JAR%" nc me "%ASM%"
