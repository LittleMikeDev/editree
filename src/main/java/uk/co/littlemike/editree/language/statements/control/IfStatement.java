package uk.co.littlemike.editree.language.statements.control;

import uk.co.littlemike.editree.language.expressions.BooleanConstant;
import uk.co.littlemike.editree.language.statements.Statement;
import uk.co.littlemike.editree.language.statements.StatementVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class IfStatement implements Statement {
    private final List<Conditional> conditionals = new ArrayList<>();
    private Optional<List<Statement>> defaults = Optional.empty();

    public IfStatement(BooleanConstant condition, Statement... statements) {
        conditionals.add(new Conditional(condition, statements));
    }

    public List<Conditional> getConditionals() {
        return conditionals;
    }

    public Optional<List<Statement>> getDefaults() {
        return defaults;
    }

    public IfStatement withCondition(BooleanConstant condition, Statement... statements) {
        conditionals.add(new Conditional(condition, statements));
        return this;
    }

    public IfStatement withDefault(Statement... statements) {
        defaults = Optional.of(Arrays.asList(statements));
        return this;
    }

    @Override
    public void visit(StatementVisitor visitor) {
        visitor.visit(this);
    }
}
