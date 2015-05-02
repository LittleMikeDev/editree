package uk.co.littlemike.editree.text.statements;

import uk.co.littlemike.editree.language.statements.Assignment;
import uk.co.littlemike.editree.text.expressions.ExpressionRenderer;


public class AssignmentRenderer implements StatementRenderer<Assignment> {

    private final ExpressionRenderer expressionRenderer = new ExpressionRenderer();

    @Override
    public void renderToContext(Assignment assignment, StatementRenderContext context) {
        context.appendLine(
                "%s = %s;",
                assignment.getVariableName(),
                expressionRenderer.render(assignment.getValue())
        );
    }
}
