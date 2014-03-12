package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.BinaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.Types.BoolType;
import org.uva.sea.ql.parser.antlr.QL4.Types.Type;

/**
 * Abstract class for eqExpr and neqExpr (a parent class for
 * all expressions that handle either is equal to or 
 * is not equal to). Contains required constructor
 * @author Sammie Katt
 *
 */
public abstract class EqualityExpr extends BinaryExpr {

	public EqualityExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public Type getType() {
		return new BoolType();
	}
}