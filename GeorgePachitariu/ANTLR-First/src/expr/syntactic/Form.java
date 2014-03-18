package expr.syntactic;

import java.util.LinkedList;
import java.util.List;

import visitor.ASTVisitor;

import expr.ASTNode;
import expr.Ident;

public class Form implements SyntacticExpressions {
	protected Ident identifier;
	protected List<Statement> list;

	public Form(Ident identifier, List<Statement> list) {
		this.identifier=identifier;
		this.list=list;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Form))
			return false;
		Form form=(Form) obj;
		return this.identifier.equals(form.identifier) &&
				this.list.equals(form.list);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this, list);
	}

	public Ident getIdent() {
		return this.identifier;
	}

	@Override
	public String toString() {
		String str=" form " +this.identifier.toString() + "{ \n";
		for(Statement s : this.list)
			str+=s.toString() + "\n";
		str+= "}";
		return str;
	}

	@Override
	public ASTNode ReplaceQuestionValue(Question q) {
		List<Statement> list=new LinkedList<>();
		for(Statement s : this.list)
			list.add((Statement)s.ReplaceQuestionValue(q));
		return new Form(this.identifier,list);
	}
}

