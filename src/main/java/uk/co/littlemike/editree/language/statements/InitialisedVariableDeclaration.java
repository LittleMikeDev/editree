package uk.co.littlemike.editree.language.statements;

import uk.co.littlemike.editree.language.semantics.DeclarationTypeMismatchException;
import uk.co.littlemike.editree.language.statements.expressions.Expression;
import uk.co.littlemike.editree.language.types.Type;

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
