package main.nl.uva.parser.elements.expressions;

import main.nl.uva.parser.elements.statements.Statement;
import main.nl.uva.parser.elements.type.Type;

public abstract class Expression extends Statement {

    protected Type _type = null;

    public Expression() {}

    public abstract Type getType();

    @Override
    public Variable getVariable(final String variableName) {
        return null;
    }

    @Override
    public abstract boolean validate();

    @Override
    public Variable findVariable(final String variableName, final Statement scopeEnd) {
        if (_parent != null) {
            return _parent.findVariable(variableName, this);
        }

        return null;
    }
}