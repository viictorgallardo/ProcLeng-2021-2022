//*****************************************************************
// Tratamiento de errores sintácticos
//
// Fichero:    ErrorSintactico.java
// Fecha:      03/03/2022
// Versión:    v1.0
// Asignatura: Procesadores de Lenguajes, curso 2021-2022
//*****************************************************************

package lib.errores;

import traductor.Token;
import lib.symbolTable.Symbol;
import lib.symbolTable.SymbolInt;
import lib.symbolTable.exceptions.*; 

import java.util.Arrays;

public class ErrorSemantico {
	final static String sep = "*************************************************************************";

	private static int contadorErrores = 0;
	private static int contadorWarnings = 0;

	public static void deteccion(AlreadyDefinedSymbolException e, Token t) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. No se puede redefinir el símbolo");
		System.err.println(sep);
	}

	public static void deteccion(SymbolNotFoundException e, Token t) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. El símbolo no está definido");
		System.err.println(sep);
	}

	public static void deteccion(IndexOOBException e, Token t, int index) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. Se ha intentado acceder a la componente inexistente: " + index);
		System.err.println(sep);
	}

	public static void deteccion(TypeErrorException e, Token t, Symbol.Types... expectedTypes) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. El tipo es incorrecto. Tipo(s) esperado(s): " + (Arrays.toString(expectedTypes)));
		System.err.println(sep);
	}

	public static void deteccion(InvocationException e, Token t, String m) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Invocación de la función '" + t.image + "' fallo: "+m);
		System.err.println(sep);
	}


	public static void deteccion(ContextException e, Token t) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Token '" + t.image + "' en contexto no valido.");
		System.err.println(sep);
	}

	// public static void deteccion(ActionInvocationException e, String mensaje, Token t) {
	// 	contadorErrores++;
	// 	System.err.println(sep);
	// 	System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
	// 			"Error al invocar a: '" + t.image + "'. " + mensaje);
	// 	System.err.println(sep);
	// }

	public static void deteccion(String mensaje, Token t) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. " + mensaje);
		System.err.println(sep);
	}

	public static void warning(String mensaje, Token t) {
		contadorWarnings++;
		System.err.println(sep);
		System.err.println("WARNING: (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. " + mensaje);
		System.err.println(sep);
	}

	public static int getContadorErrores() {
		return contadorErrores;
	}
}
