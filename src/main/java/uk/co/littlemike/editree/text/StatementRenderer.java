package uk.co.littlemike.editree.text;

import uk.co.littlemike.editree.language.statements.Statement;
import uk.co.littlemike.editree.language.statements.StatementVisitor;
import uk.co.littlemike.editree.language.statements.VariableDeclaration;
import uk.co.littlemike.editree.language.statements.control.WhileLoop;

public class StatementRenderer {
    private final ExpressionRenderer expressionRenderer = new ExpressionRenderer();

    public String render(Statement statement) {
        return renderWithContext(statement, new StatementRenderContext());
    }

    private String renderWithContext(Statement statement, StatementRenderContext context) {
        statement.visit(new StatementVisitor() {
            @Override
            public void visit(VariableDeclaration declaration) {
                renderToString(declaration, context);
            }
            @Override
            public void visit(WhileLoop loop) {
                renderToString(loop, context);
            }
        });
        return context.getRenderedText();
    }

    public void renderToString(VariableDeclaration declaration, StatementRenderContext context) {
        StringBuilder text = new StringBuilder();
        text.append(declaration.getType().getName() + " " + declaration.getName());
        declaration.getInitialValue().ifPresent((initialValue) ->
                        text.append(" = ")
                                .append(expressionRenderer.render(initialValue))
        );
        text.append(";");
        context.appendLine(text.toString());
    }

    public void renderToString(WhileLoop loop, StatementRenderContext context) {
        context.appendLine(String.format(
                "while (%s) {",
                expressionRenderer.render(loop.getCondition())
        ));

        for (Statement statement : loop.getStatements()) {
            context.increaseIndent();
            renderWithContext(statement, context);
            context.decreaseIndent();
        }
        context.appendLine("}");
    }
}
