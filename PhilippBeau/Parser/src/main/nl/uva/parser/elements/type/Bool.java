package main.nl.uva.parser.elements.type;

import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.statements.Statement;

public class Bool extends Type {

    private final String _value;

    public Bool(final Statement parent, final String value) {
        super("Boolean", parent);

        _value = value;
    }

    @Override
    protected boolean validateImpl() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setRight(final Expression cEx) {
        // TODO Auto-generated method stub

    }
}
