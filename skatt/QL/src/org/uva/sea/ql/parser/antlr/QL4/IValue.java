package org.uva.sea.ql.parser.antlr.QL4;

/**
 * The interface for values. Defines all necessary 
 * functions for a value in the QL4 grammar.
 * @author Sammie
 *
 */
public interface IValue {
	
	/**
	 * Returns whether value equals the object itself
	 * @return evaluation of equality 
	 */
	Boolean equals(Value value);
	
	/**
	 * Defines how the value should be printed as boolean
	 * @return a boolean
	 */
	Boolean asBoolean();
	
	/**
	 * Defines how the value should be printed as integer
	 * @return a boolean
	 */
	Integer asInteger();
	
	/**
	 * Defines how the value should be printed as double
	 * @return a boolean
	 */
	Double asDouble();
	
	/**
	 * Force values to be printable with custom toString
	 * @return a string defining the object (the value)
	 */
	String toString();
	
}