package main.nl.uva.parser.elements.expressions.atoms;

import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.expressions.Variable;

public class VariableAtom extends Expression {

    private final String _variableName;

    private Variable _linkedVariable = null;

    public VariableAtom(final String variableName) {
        _variableName = variableName;
    }

    public void setLinkedVariable(final Variable variable) {
        _linkedVariable = variable;
    }

    @Override
    public String toString() {
        return _variableName;
    }

    @Override
    public boolean validate() {
        if (_parent == null) {
            return false;
        }

        Variable linkedVariable = _parent.findVariable(_variableName);
    }
}
