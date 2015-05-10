package uk.co.littlemike.editree.language.statements;

import uk.co.littlemike.editree.language.expressions.Expression;
import uk.co.littlemike.editree.language.types.Type;

public class VariableDeclaration implements Statement {
    private final Type type;
    private final String name;
    private final Expression initialValue;

    public VariableDeclaration(Type type, String name) {
        this.type = type;
        this.name = name;
        this.initialValue = null;
    }

    public VariableDeclaration(String name, Expression initialValue) {
        this.type = initialValue.getType();
        this.name = name;
        this.initialValue = initialValue;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Expression getInitialValue() {
        return initialValue;
    }

    @Override
    public void visit(StatementVisitor visitor) {
        visitor.visit(this);
    }

    public boolean hasInitialValue() {
        return getInitialValue() != null;
    }
}
