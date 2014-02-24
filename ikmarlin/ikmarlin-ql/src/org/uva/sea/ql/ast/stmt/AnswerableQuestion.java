package org.uva.sea.ql.ast.stmt;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.checker.StmtVisitor;

public class AnswerableQuestion extends Question {

	public AnswerableQuestion(Ident ident, String label, Expr type) {
		super(ident, label, type);
	}

	@Override
	public void accept(StmtVisitor sv) {
		sv.visit(this);
	}

}
