package uk.co.littlemike.editree.text;

import uk.co.littlemike.editree.language.statements.Assignment;
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

            @Override
            public void visit(Assignment assignment) {
                renderToString(assignment, context);
            }
        });
        return context.getRenderedText();
    }

    private void renderToString(Assignment assignment, StatementRenderContext context) {
        context.appendLine(String.format(
                "%s = %s;",
                assignment.getVariableName(),
                expressionRenderer.render(assignment.getValue())
        ));
    }

    private void renderToString(VariableDeclaration declaration, StatementRenderContext context) {
        if (declaration.hasInitialValue()) {
            context.appendLine(String.format(
                    "%s %s = %s;",
                    declaration.getType().getName(),
                    declaration.getName(),
                    expressionRenderer.render(declaration.getInitialValue().get())
            ));
        }
        else {
            context.appendLine(String.format(
                    "%s %s;",
                    declaration.getType().getName(),
                    declaration.getName()
            ));
        }
    }

    private void renderToString(WhileLoop loop, StatementRenderContext context) {
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
