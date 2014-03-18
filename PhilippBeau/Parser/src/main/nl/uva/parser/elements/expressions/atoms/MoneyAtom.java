package main.nl.uva.parser.elements.expressions.atoms;

import main.nl.uva.parser.elements.type.Money;
import main.nl.uva.parser.elements.type.Value;
import main.nl.uva.parser.elements.validation.ASTValidation;
import main.nl.uva.parser.elements.validation.Scope;

public class MoneyAtom extends AtomExpression {

    public MoneyAtom() {
        this("0.0");
    }

    public MoneyAtom(final String value) {
        _value = new Money(Double.parseDouble(value));
    }

    public MoneyAtom(final Money value) {
        _value = value;
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        return new ASTValidation();
    }

    @Override
    public Value getValue() {
        return _value;
    }

    @Override
    public String toString() {
        return "Money: " + _value;
    }
}
