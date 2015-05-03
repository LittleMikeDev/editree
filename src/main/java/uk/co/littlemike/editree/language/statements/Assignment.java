package uk.co.littlemike.editree.language.statements;

import uk.co.littlemike.editree.language.expressions.Expression;

public class Assignment implements Statement {
    private final String variableName;
    private final Expression value;

    public Assignment(String variableName, Expression value) {
        this.variableName = variableName;
        this.value = value;
    }

    @Override
    public void visit(StatementVisitor visitor) {
        visitor.visit(this);
    }

    public String getVariableName() {
        return variableName;
    }

    public Expression getValue() {
        return value;
    }
}
