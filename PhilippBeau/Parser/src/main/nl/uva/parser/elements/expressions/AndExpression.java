package main.nl.uva.parser.elements.expressions;

public class AndExpression extends AdvancedExpression {

    public AndExpression(final Expression left, final Expression right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return _left + " && " + _right;
    }

    @Override
    public Object getResult() {
        return (Boolean) _left.getResult() && (Boolean) _right.getResult();
    }
}
