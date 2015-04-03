package uk.co.littlemike.editor.language.statements.expressions;

import uk.co.littlemike.editor.language.types.Type;
import uk.co.littlemike.editor.language.types.Types;

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
}
