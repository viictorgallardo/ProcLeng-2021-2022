//*****************************************************************
// File:   SymbolArray.java
// Author: Procesadores de Lenguajes-University of Zaragoza
// Date:   julio 2021
// Coms:   Atributos públicos para evitar el uso de getters y setters
//*****************************************************************
package lib.symbolTable;

import java.util.Vector;

import lib.symbolTable.exceptions.TypeErrorException;


public class SymbolArray extends Symbol implements Cloneable {
    public int minInd;
    public int maxInd;
    public Types baseType;
    public Vector v ;

    public SymbolArray(String _name) {
        super(_name, Types.ARRAY, ParameterClass.NONE); 
    	minInd = -1;
        maxInd = -1;
        baseType = Types.UNDEFINED;
    }

    public SymbolArray(String _name, int _minInd, int _maxInd, Types _baseType) throws TypeErrorException {
        super(_name, Types.ARRAY, ParameterClass.NONE);
        minInd = _minInd;
        maxInd = _maxInd;
        baseType = _baseType;
        if (_baseType == Types.INT) {
            v = new Vector<Integer>(_maxInd-_minInd);
        }
        else if (_baseType == Types.BOOL) {
            v = new Vector<Boolean>(_maxInd-_minInd);
        }
        else if (_baseType == Types.CHAR) {
            v = new Vector<Character>(_maxInd-_minInd);
        }
        else {
            throw new TypeErrorException();
        } 
    }

    public SymbolArray(String _name, int _minInd, int _maxInd, Types _baseType, ParameterClass _class) throws TypeErrorException {
        super(_name, Types.ARRAY, _class); 
        minInd = _minInd;
        maxInd = _maxInd;
        baseType = _baseType;
        if (_baseType == Types.INT) {
            v = new Vector<Integer>(_maxInd-_minInd);
        }
        else if (_baseType == Types.BOOL) {
            v = new Vector<Boolean>(_maxInd-_minInd);
        }
        else if (_baseType == Types.CHAR) {
            v = new Vector<Character>(_maxInd-_minInd);
        }
        else {
            throw new TypeErrorException();
        }
    }

    public SymbolArray(String _name, int _numComp, Types _baseType) throws TypeErrorException {
        super(_name, Types.ARRAY, ParameterClass.NONE);
        minInd = 0;
        maxInd = _numComp - 1;
        baseType = _baseType;
        if (_baseType == Types.INT) {
            v = new Vector<Integer>(_numComp);
        }
        else if (_baseType == Types.BOOL) {
            v = new Vector<Boolean>(_numComp);
        }
        else if (_baseType == Types.CHAR) {
            v = new Vector<Character>(_numComp);
        }
        else {
            throw new TypeErrorException();
        }
    }

    public SymbolArray(String _name, int _numComp, Types _baseType, ParameterClass _class) throws TypeErrorException {
        super(_name, Types.ARRAY, _class); 
        minInd = 0;
        maxInd = _numComp - 1;
        baseType = _baseType;
        if (_baseType == Types.INT) {
            v = new Vector<Integer>(_numComp);
        }
        else if (_baseType == Types.BOOL) {
            v = new Vector<Boolean>(_numComp);
        }
        else if (_baseType == Types.CHAR) {
            v = new Vector<Character>(_numComp);
        }
        else {
            throw new TypeErrorException();
        }
    }

    public String toString() {
        return "(" + name + "," + type +  "," +  minInd + "," + maxInd + "," + 
                     baseType + "," + parClass + "," + nivel + ")";
    }
    
    public SymbolArray clone () {
    	return (SymbolArray) super.clone(); 
    }

}