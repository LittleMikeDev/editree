package uk.co.littlemike.editree.text.statements.control;

import uk.co.littlemike.editree.language.expressions.BooleanConstant;
import uk.co.littlemike.editree.language.statements.Statement;
import uk.co.littlemike.editree.language.statements.control.Conditional;
import uk.co.littlemike.editree.language.statements.control.IfStatement;
import uk.co.littlemike.editree.text.expressions.ExpressionRenderer;
import uk.co.littlemike.editree.text.statements.StatementRenderContext;
import uk.co.littlemike.editree.text.statements.StatementRenderer;

import java.util.List;
import java.util.Optional;

public class IfRenderer implements StatementRenderer<IfStatement> {
    private final ExpressionRenderer expressionRenderer = new ExpressionRenderer();
    private final StatementRenderer<Statement> statementRenderer;

    public IfRenderer(StatementRenderer<Statement> statementRenderer) {
        this.statementRenderer = statementRenderer;
    }

    @Override
    public void renderToContext(IfStatement ifStatement, StatementRenderContext context) {
        renderConditionalsWithoutClosingBrace(ifStatement, context);

        renderElseWithoutClosingBrace(ifStatement.getDefaults(), context);

        context.appendLine("}");
    }

    private void renderElseWithoutClosingBrace(Optional<List<Statement>> defaults, StatementRenderContext context) {
        if (defaults.isPresent()) {
            context.appendLine("} else {");
            renderStatementsWithIncreasedIndent(defaults.get(), context);
        }
    }

    private void renderConditionalsWithoutClosingBrace(IfStatement ifStatement, StatementRenderContext context) {
        String conditionFormat = "if (%s) {";
        for (Conditional conditional : ifStatement.getConditionals()) {
            renderCondition(conditional.getCondition(), conditionFormat, context);

            renderStatementsWithIncreasedIndent(conditional.getStatements(), context);

            conditionFormat = "} else if (%s) {";
        }
    }

    private void renderStatementsWithIncreasedIndent(List<Statement> statements, StatementRenderContext context) {
        for (Statement statement : statements) {
            statementRenderer.renderToContext(statement, context.withIncreasedIndent());
        }
    }

    private void renderCondition(BooleanConstant condition, String conditionFormat, StatementRenderContext context) {
        context.appendLine(
                conditionFormat,
                expressionRenderer.render(condition)
        );
    }
}
