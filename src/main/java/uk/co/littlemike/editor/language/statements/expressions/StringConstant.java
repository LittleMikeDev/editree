package uk.co.littlemike.editor.language.statements.expressions;

import uk.co.littlemike.editor.language.statements.expressions.Expression;
import uk.co.littlemike.editor.language.types.Type;
import uk.co.littlemike.editor.language.types.Types;

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
}
