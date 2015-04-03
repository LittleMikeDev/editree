package uk.co.littlemike.editor.language.statements;

import uk.co.littlemike.editor.language.statements.expressions.Expression;
import uk.co.littlemike.editor.language.types.Type;

public class InitialisedVariableDeclaration extends VariableDeclaration {

    private final Expression initialValue;

    public InitialisedVariableDeclaration(Type type, String name, Expression initialValue) {
        super(type, name);
        this.initialValue = initialValue;
    }

    public Expression getInitialValue() {
        return initialValue;
    }
}
