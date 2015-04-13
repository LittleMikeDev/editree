package uk.co.littlemike.editree.language.statements;

import uk.co.littlemike.editree.language.types.Type;

public class VariableDeclaration implements Statement {
    private final Type type;
    private final String name;

    public VariableDeclaration(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    @Override
    public void visit(StatementVisitor visitor) {
        visitor.visit(this);
    }
}
