package org.uva.sea.ql.parser.antlr.QL4;

/**
 * QLinteger object for QL4 grammar. Is an instance of Value and acts as
 * a type of value in the QL4 package.
 * @author Sammie Katt
 *
 */
public class QLinteger extends Value {

	/**
	 * The value of the object QLintger is an int
	 */
	int value;
	
	/**
	 * Compares the value with this.value
	 * @param value is the value to compare this with
	 * @return is a boolean, evaluating whether value input equals this
	 */
	public Boolean equals(Value value) {
		return Integer.compare(this.value, value.asInteger()) > 0;
	}
	
	/**
	 * Constructor for when initiated with a string. The 
	 * input will be translated to an int: 
	 * 
	 * @param value
	 */
	QLinteger(String value) {
		this.value = Integer.parseInt(value);
	}
	
	/**
	 * returns the value as a boolean (check if its 1)
	 * @return value
	 */
	public Boolean asBoolean() {
		return value == 1;
	}
	
	/**
	 * return the value as a string by String.parse
	 * @return value as string
	 */
	public String toString() {
		return String.valueOf(value);
	}

	/**
	 * returns the value 
	 * @return value
	 */
	public Integer asInteger() {
		return this.value;
	}

	/**
	 * returns the value as a double 
	 * @return value parsed to double
	 */
	public Double asDouble() {
		return Double.valueOf(this.value);
	}
}
