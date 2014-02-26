package expr;


public class Ident extends Expression {
	private String identifier;

	public Ident(String identifier) {
		super();
		this.identifier=identifier;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Ident))
			return false;
		Ident ident=(Ident) obj;
		return this.identifier.equals(ident.identifier);
	}
}
