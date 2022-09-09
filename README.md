# ProcLeng-2021-2022
Repositorio privado de las prácticas de la asignatura Procesadores de Lenguajes, curso 2021-2022

Este proyecto fue realizado por:
Marcos Garralaga Blasco (795936[@unizar.es])
Victor Gallardo Sánchez (801159[@unizar.es])

Consiste en implementar un compilador del lenguaje desarrollado por UNIZAR, AdaC. Este lenguaje es una mezcla entre el lenguaje Ada y C.

A continuación se explican las características del lenguaje aceptado por el compilador. Cabe destacar que el compilador acepta el lenguaje de AdaC en su 
totalidad.

    Se ha atacado hasta el nivel 4 (incluido) de la practica: 
    El lenguaje permite el uso de parámetros escalares y de vectores, tanto por valor como por referencia 
    en procedimientos y funciones.
    
    Otras carácteristicas del lenguaje aceptado que permite el compilador son:
    El lenguaje tiene un sistema de tipos rígido (no hay ninguna compatibilidad entre los tipos para
    ninguna operación):
        • Cuatro tipos de constantes literales: integer, boolean, character y string.
        • Tres tipos de variables y parámetros: integer, boolean, character, tanto simples, como vectores 
        de índice entero cuya primera componente es la número 0.
        • Las variables simples, parámetros simples, y las componentes de variables y parámetros vectores 
        son asignables. Ni los procedimientos ni las funciones ni el programa son asignables.
        
    Tambien existen otras herramientas:
        • Dos funciones para convertir un valor simple de un tipo a otro: int2char y char2int.
        • Comparacion de vectores: Dos vectores son del mismo tipo solamente si sus componentes son del
        mismo tipo y tienen la misma cantidad de componentes.

    Sobre operadores:
        • Los operadores aritméticos (+, -, *, div, mod) sólo admiten operandos simples de tipo integer.
        • Los operadores booleanos (and, or, not) sólo admiten operandos simples de tipo boolean.
        • Los operadores relacionales ( >, >=, <, <=, ==, <> ) sólo admiten operandos simples del mismo 
        tipo
    Sigue la jerarquia de los operadores de la semántica de adaC: (por orden creciente de precedencia)
        >, >=, <, <=, ==, <>: no asociativos
        +, -, or: asociatividad por la izquierda
        +, - (unarios): no asociativos
        *, div, mod, and: asociatividad por la izquierda
        not: no asociativo

    Sobre la entrada/salida del programa:
        • AdaC dispone de las funciones get, put, put_line y skip_line.
        • La instrucción de lectura (get) sólo admite como argumentos asignablessimples de tipo integer o 
        character.
        • Las instrucciones de escritura (put y putline) admiten valores simples de tipo integer, boolean,
         character y string.
        • La instruccion skip_line consume caracteres de entrada hasta encontrar un caracter '\n'

    Sobre la asignacion:
        • La instrucción de asignación (<asig> := <exp>) sólo admite expresiones del mismo tipo que el
        asignable.
        • Los vectores NO son asignables para esta instrucción (aunque sus componentes sí lo son).

    Sobre if y while:
        • La condición de las instrucciones de selección y de iteración sólo puede ser simple boolean.

    Sobre procedimientos y funciones:
        • Los parámetros de tipo val de un procedimiento o función sólo admiten argumentos del mismo tipo.
        • Los parámetros de tipo ref de un procedimiento o función sólo admiten asignables del mismo tipo.
        • En la invocación de un procedimiento o función deben coincidir tanto el tipo de cada argumento y
        parámetro, como la cantidad (no hay parámetros por defecto).
        • El programa principal no es invocable
        
La política de recuperación de errores que se ha utilizado es el modo pánico. En caso de encontrar un 
error el compilador saltará tokens 
hasta que encuentre un "end" o un ";". El modo pánico se lleva a cabo a nivel de instrucción y de bloque, 
por lo que si el error da en una instrucción while o if, salta tokens hasta el "end". Sin embargo si 
da error en otra situación salta tokens hasta el ";".
Cabe recordar que si por ejemplo, hay un if dentro de un while y el error se comete en el while, comerá 
hasta el primer "end" que se encuentre, es decir el del if. Esto es un caso de error semántico que se 
tratará mas adelante.

La organización de directorios se basa en la figura 1 del guión de la práctica

Se han añadido excepciones (IndexOOBException, ContextException, TypeErrorException e InvocationException)
para dar feedback mas exacto al usuario de los errores del programa.
También se ha modificado ErrorSemantico para dar soporte a mostrar estos errores.
Además, se ha modificado la clase Attributes, añadiendo los campos baseType (tipo del vector si se esta
representando un vector), tam (tamaño del vector si se esta representando un vector) e isConstant (booleano
para saber si conocemos con certeza el valor de la expresión)

Para compilar un archivo .adac se puede utilizar el script .compileAll, este generará un .pcode correspondiente a cada archivo .adac que haya en el directorio.
El archivo compilado .pcode contiene la instrucciones en código P del programa compilado.

