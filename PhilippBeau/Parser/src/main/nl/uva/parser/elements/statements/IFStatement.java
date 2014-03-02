package main.nl.uva.parser.elements.statements;

public class IFStatement extends Statement {

    public IFStatement(final Statement parent) {
        super("", parent);
    }

    @Override
    protected boolean validateImpl() {
        boolean valid = _parent.validates(this);

        if (!valid) {
            System.err.println(this + " -> is very very wrong");
        }

        return valid;
    }

    @Override
    public String toString() {
        return "IFStatement " + _id;
    }
}
