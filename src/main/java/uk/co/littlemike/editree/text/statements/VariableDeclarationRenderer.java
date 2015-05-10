package uk.co.littlemike.editree.text.statements;

import uk.co.littlemike.editree.language.statements.VariableDeclaration;
import uk.co.littlemike.editree.text.expressions.ExpressionRenderer;

public class VariableDeclarationRenderer implements StatementRenderer<VariableDeclaration> {

    private final ExpressionRenderer expressionRenderer = new ExpressionRenderer();

    @Override
    public void renderToContext(VariableDeclaration declaration, StatementRenderContext context) {
        if (declaration.hasInitialValue()) {
            context.appendLine(
                    "%s %s = %s;",
                    declaration.getType().getName(),
                    declaration.getName(),
                    expressionRenderer.render(declaration.getInitialValue())
            );
        } else {
            context.appendLine(
                    "%s %s;",
                    declaration.getType().getName(),
                    declaration.getName()
            );
        }
    }
}
