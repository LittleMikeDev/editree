package uk.co.littlemike.editree.language.statements.control;

import uk.co.littlemike.editree.language.expressions.BooleanConstant;
import uk.co.littlemike.editree.language.statements.VariableDeclaration;

import java.util.Arrays;
import java.util.List;

public class WhileLoop {
    private final BooleanConstant condition;
    private final List<VariableDeclaration> statements;

    public WhileLoop(BooleanConstant condition, VariableDeclaration... statements) {
        this.condition = condition;
        this.statements = Arrays.asList(statements);
    }

    public BooleanConstant getCondition() {
        return condition;
    }

    public List<VariableDeclaration> getStatements() {
        return statements;
    }
}
