package ast.expr;

import typecheck.Symboles;
import ast.ASTNode;
import ast.types.Types;

public abstract class Expr implements ASTNode{
	public abstract Types typeof(Symboles symboles);

}
