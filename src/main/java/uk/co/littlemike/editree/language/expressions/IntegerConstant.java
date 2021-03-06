package uk.co.littlemike.editree.language.expressions;

import uk.co.littlemike.editree.language.types.Type;
import uk.co.littlemike.editree.language.types.Types;

public class IntegerConstant implements Expression {
    private final int value;

    public IntegerConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public Type getType() {
        return Types.Integer;
    }

    @Override
    public void visit(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
}
