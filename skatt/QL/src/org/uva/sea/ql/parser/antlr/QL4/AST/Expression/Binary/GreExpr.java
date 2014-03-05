package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;

/**
 * Represents the greater than expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class GreExpr extends BinaryExpr {

	public GreExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public String toString() {
		return "GreaterThan(" + lhs.toString() + ", " + rhs.toString() + ")";
	}
}
