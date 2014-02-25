package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.IVisitor;

public class NullType extends Type {

	@Override
	public void accept(IVisitor visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String show() {
		return "No Type Available";
	}

	@Override
	public boolean isCompatibleWith(Type typeOf) {
		return false;
	}

}
