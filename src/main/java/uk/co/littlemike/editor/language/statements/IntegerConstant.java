package uk.co.littlemike.editor.language.statements;

import uk.co.littlemike.editor.language.statements.expressions.Expression;

public class IntegerConstant implements Expression {
    private final int value;

    public IntegerConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
