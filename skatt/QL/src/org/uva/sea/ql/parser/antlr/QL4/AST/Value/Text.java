package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

import org.uva.sea.ql.parser.antlr.QL4.AST.Types.StringType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

public class Text extends Value {

	private final String value;
	
	public Text(String value) {
		this.value = value;
	}

	@Override
	public <T> T accept(IQLVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Type getType() {
		return new StringType();
	}
	
	public String toString() {
		return value;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Text other = (Text) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
