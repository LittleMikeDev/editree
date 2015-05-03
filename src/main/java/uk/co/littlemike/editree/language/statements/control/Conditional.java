package uk.co.littlemike.editree.language.statements.control;

import uk.co.littlemike.editree.language.expressions.BooleanConstant;
import uk.co.littlemike.editree.language.statements.Statement;

import java.util.Arrays;
import java.util.List;

public class Conditional {
    private final BooleanConstant condition;
    private final List<Statement> statements;

    Conditional(BooleanConstant condition, Statement... statements) {
        this.condition = condition;
        this.statements = Arrays.asList(statements);
    }

    public BooleanConstant getCondition() {
        return condition;
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
