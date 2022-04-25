//*****************************************************************
// File:   Attributes.java
// Author: Procesadores de Lenguajes-University of Zaragoza
// Date:   enero 2022
//         Clase única para almacenar los atributos que pueden aparecer en el traductor de adac
//         Se hace como clase plana, por simplicidad. Los atributos que se pueden almacenar
//         se autoexplican con el nombre
//*****************************************************************

package lib.attributes;
import lib.symbolTable.*;
import lib.symbolTable.Symbol.Types;

import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;

public class Attributes implements Cloneable {
    public Symbol.Types type;
    public Symbol.ParameterClass parClass;

    public int valInt;
    public boolean valBool;
    public char valChar;
    public String valString;
    public boolean isConstant;

    public Attributes(int value) {
        this.valInt = value;
        this.type = Symbol.Types.INT;
        this.parClass = Symbol.ParameterClass.NONE;
        this.isConstant = true;
    }

    public Attributes(boolean value) {
        this.valBool = value;
        this.type = Symbol.Types.BOOL;
        this.parClass = Symbol.ParameterClass.NONE;
        this.isConstant = true;
    }

    public Attributes(char value) {
        this.valChar = value;
        this.type = Symbol.Types.CHAR;
        this.parClass = Symbol.ParameterClass.NONE;
        this.isConstant = true;
    }

    public Attributes(String value) {
        this.valString = value;
        this.type = Symbol.Types.STRING;
        this.parClass = Symbol.ParameterClass.NONE;
        this.isConstant = true;
    }

    public Attributes(Symbol.Types tipo, Symbol.ParameterClass parameterClass) {
        this.type = tipo;
        this.parClass = parameterClass;
        this.isConstant = false;
    }

    public Attributes() {
        this.type = Symbol.Types.UNDEFINED;
        this.parClass = Symbol.ParameterClass.NONE;
        this.isConstant = false;
    }



    public Attributes clone() {
    	try {
    		return (Attributes) super.clone();
    	}
    	catch (CloneNotSupportedException e) {
    		return null; 
    	}
    }

    public String toString() {
        String output = "type=" + type + " parClass=" + parClass;
        if(isConstant) {
            switch (this.type) {
                case INT:
                    output += " value="+valInt;
                    break;
                case CHAR:
                    output += " value="+valChar;
                    break;
                case STRING:
                    output += " value="+valString;
                    break;
                case BOOL:
                    output += " value="+valBool;
                    break;
                default:
                    break;
            }
        }
        else {
            output += " non-constant value";
        }

        output += "\n";
        
        return output;
    }
}
