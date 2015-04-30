package uk.co.littlemike.editree.language.statements.control;

import uk.co.littlemike.editree.language.expressions.BooleanConstant;
import uk.co.littlemike.editree.language.statements.Statement;
import uk.co.littlemike.editree.language.statements.StatementVisitor;

import java.util.Arrays;
import java.util.List;

public class WhileLoop implements Statement {
    private final BooleanConstant condition;
    private final List<Statement> statements;

    public WhileLoop(BooleanConstant condition, Statement... statements) {
        this.condition = condition;
        this.statements = Arrays.asList(statements);
    }

    public BooleanConstant getCondition() {
        return condition;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public void visit(StatementVisitor visitor) {
        visitor.visit(this);
    }
}
