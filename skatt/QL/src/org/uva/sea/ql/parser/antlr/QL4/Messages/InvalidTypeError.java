package org.uva.sea.ql.parser.antlr.QL4.Messages;

import java.util.HashMap;

import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;

/**
 * Represents the error of an invalid type in an expression
 * @author Sammie Katt
 *
 */
public class InvalidTypeError extends QLErrorMsg {

	private final Expression expr;
	private final Type type;

	public InvalidTypeError(Expression expr, Type type) {
		this.type = type;
		this.expr = expr;
	}
	
	@Override
	public String toString() {
		return "Expression " + expr + " does not contain expected type " + type + ", but type " + expr.getType(new HashMap<Identifier, Question>());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expr == null) ? 0 : expr.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvalidTypeError other = (InvalidTypeError) obj;
		if (expr == null) {
			if (other.expr != null)
				return false;
		} else if (!expr.equals(other.expr))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}
