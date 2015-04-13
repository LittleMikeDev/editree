package uk.co.littlemike.editree.language.expressions;

import uk.co.littlemike.editree.language.types.Type;
import uk.co.littlemike.editree.language.types.Types;

public enum BooleanConstant implements Expression {
    TRUE(true), FALSE(false);

    private final boolean value;

    BooleanConstant(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public Type getType() {
        return Types.Boolean;
    }

    @Override
    public void visit(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
}
