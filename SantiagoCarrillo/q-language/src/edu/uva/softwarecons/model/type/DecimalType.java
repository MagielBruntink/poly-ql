package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/25/14
 */
public class DecimalType extends NumericType{

    public float value;

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitDecimalType(this);
    }

    @Override
    public String toString() {
        return "decimal";
    }
}
