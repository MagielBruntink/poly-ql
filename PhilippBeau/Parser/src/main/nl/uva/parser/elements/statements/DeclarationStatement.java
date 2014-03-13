package main.nl.uva.parser.elements.statements;

import main.nl.uva.parser.elements.expressions.Variable;
import main.nl.uva.parser.elements.ui.DeclarationUIElement;
import main.nl.uva.parser.elements.ui.UIElement;
import main.nl.uva.parser.elements.validation.ASTValidation;
import main.nl.uva.parser.elements.validation.Scope;

public class DeclarationStatement extends Statement {

    private final String _function;

    private final Variable _variable;

    public DeclarationStatement(final Variable variable, final String function) {
        _function = function;
        _variable = variable;
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        ASTValidation valid = _variable.validate(scope);

        scope.addToScope(_variable);
        return valid;
    }

    @Override
    public void removeYourselfFromScope(final Scope scope) {
        scope.removeFromScope(_variable);
    }

    @Override
    public UIElement getLayout() {
        return new DeclarationUIElement(_variable, _function);
    }

    @Override
    public String toString() {
        return _variable + " " + _function;
    }
}
