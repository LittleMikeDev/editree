package uk.co.littlemike.editree.text.statements;

import uk.co.littlemike.editree.language.statements.Statement;
import uk.co.littlemike.editree.language.statements.control.WhileLoop;
import uk.co.littlemike.editree.text.expressions.ExpressionRenderer;

public class WhileLoopRenderer implements StatementRenderer<WhileLoop> {

    private final ExpressionRenderer expressionRenderer = new ExpressionRenderer();
    private final StatementRenderer<Statement> statementRenderer;

    public WhileLoopRenderer(StatementRenderer<Statement> statementRenderer) {
        this.statementRenderer = statementRenderer;
    }

    @Override
    public void renderToContext(WhileLoop loop, StatementRenderContext context) {
        context.appendLine(
                "while (%s) {",
                expressionRenderer.render(loop.getCondition())
        );

        for (Statement statement : loop.getStatements()) {
            statementRenderer.renderToContext(statement, context.withIncreasedIndent());
        }

        context.appendLine("}");
    }
}
