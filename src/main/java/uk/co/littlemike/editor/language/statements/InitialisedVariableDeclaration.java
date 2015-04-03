package uk.co.littlemike.editor.language.statements;

import uk.co.littlemike.editor.language.semantics.DeclarationTypeMismatchException;
import uk.co.littlemike.editor.language.statements.expressions.Expression;
import uk.co.littlemike.editor.language.types.Type;

public class InitialisedVariableDeclaration extends VariableDeclaration {

    private final Expression initialValue;

    public InitialisedVariableDeclaration(Type type, String name, Expression initialValue) {
        super(type, name);
        this.initialValue = initialValue;

        if (type != initialValue.getType()) {
            throw new DeclarationTypeMismatchException(name, type, initialValue.getType());
        }
    }

    public Expression getInitialValue() {
        return initialValue;
    }
}
