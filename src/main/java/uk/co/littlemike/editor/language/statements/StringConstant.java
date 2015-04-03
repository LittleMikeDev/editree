package uk.co.littlemike.editor.language.statements;

import uk.co.littlemike.editor.language.statements.expressions.Expression;

public class StringConstant implements Expression {

    private final String value;

    public StringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
