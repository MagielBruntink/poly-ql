package org.uva.sea.ql.parser.antlr.QL4.AST.Types;

import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;


/**
 * Represents the mathematical or numeric type in QL DSL
 * @author Sammie Katt
 *
 */
public class NumberType extends Type {

	@Override
	public int hashCode() {
		return 101;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() == obj.getClass())
			return true;
		else 
			return false;
		
	}

	@Override
	public <T> T accept(IQLVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "NumberType";
	}
}