package uk.co.littlemike.editree.language.statements;

import uk.co.littlemike.editree.language.expressions.Expression;
import uk.co.littlemike.editree.language.semantics.DeclarationTypeMismatchException;
import uk.co.littlemike.editree.language.types.Type;

import java.util.Optional;

public class VariableDeclaration implements Statement {
    private final Type type;
    private final String name;
    private final Optional<Expression> initialValue;

    public VariableDeclaration(Type type, String name) {
        this.type = type;
        this.name = name;
        this.initialValue = Optional.empty();
    }

    public VariableDeclaration(Type type, String name, Expression initialValue) {
        this.type = type;
        this.name = name;
        this.initialValue = Optional.of(initialValue);

        if (type != initialValue.getType()) {
            throw new DeclarationTypeMismatchException(name, type, initialValue.getType());
        }
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Optional<Expression> getInitialValue() {
        return initialValue;
    }

    @Override
    public void visit(StatementVisitor visitor) {
        visitor.visit(this);
    }

    public boolean hasInitialValue() {
        return getInitialValue().isPresent();
    }
}
