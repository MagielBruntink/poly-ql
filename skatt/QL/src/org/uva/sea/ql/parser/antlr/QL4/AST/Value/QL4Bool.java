package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

/**
 * Representation of a boolean in the QL4 AST
 * @author Sammie Katt
 *
 */
public class QL4Bool extends QL4Value {

	boolean value;
	
	/**
	 * Constructor instantiates object and sets its value
	 * Converts string input to boolean
	 * Ignores cases (so tRue is considered true)
	 */
	public QL4Bool(String stringValue) {
		this.value = (stringValue.equalsIgnoreCase("true")) ? true : false;
	}
	
	public String toString() {
		return String.valueOf(value);
	}
}