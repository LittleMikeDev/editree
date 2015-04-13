package uk.co.littlemike.editree.language.expressions;

import uk.co.littlemike.editree.language.types.Type;
import uk.co.littlemike.editree.language.types.Types;

public class StringConstant implements Expression {

    private final String value;

    public StringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public Type getType() {
        return Types.String;
    }

    @Override
    public void visit(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
}
