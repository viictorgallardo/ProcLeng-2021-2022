//*****************************************************************
// File:   SymbolString.java
// Author: Procesadores de Lenguajes-University of Zaragoza
// Date:   julio 2021
// Coms:   Atributos públicos para evitar el uso de getters y setters
//*****************************************************************

package lib.symbolTable;

public class SymbolString extends Symbol implements Cloneable {
    public String value;

    public SymbolString(String _name) {
    	super(_name, Types.STRING, ParameterClass.NONE, true);
        value = "";
    }

    public SymbolString(String _name, ParameterClass _class) {
    	super(_name, Types.STRING, _class, true);
        value = "";
    }

    public SymbolString(String _name, String _value, ParameterClass _class) {
    	super(_name, Types.STRING, _class, true);
        value = _value;
    }

    public String toString() {
        return "(" + name + "," + type + "," + value + "," + parClass + "," + nivel + ")";
    }
    
    public SymbolString clone () {
    	return (SymbolString) super.clone(); 
    }
}
