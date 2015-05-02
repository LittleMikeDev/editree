package uk.co.littlemike.editree.text;

import uk.co.littlemike.editree.language.statements.Assignment;
import uk.co.littlemike.editree.language.statements.Statement;
import uk.co.littlemike.editree.language.statements.StatementVisitor;
import uk.co.littlemike.editree.language.statements.VariableDeclaration;
import uk.co.littlemike.editree.language.statements.control.WhileLoop;

public class StatementRenderer {
    private final ExpressionRenderer expressionRenderer = new ExpressionRenderer();

    public String render(Statement statement) {
        StatementRenderContext context = new StatementRenderContext();
        renderToContext(statement, context);
        return context.getRenderedText();
    }

    private void renderToContext(Statement statement, StatementRenderContext context) {
        statement.visit(new StatementVisitor() {
            @Override
            public void visit(VariableDeclaration declaration) {
                renderDeclarationToContext(declaration, context);
            }
            @Override
            public void visit(WhileLoop loop) {
                renderLoopToContext(loop, context);
            }

            @Override
            public void visit(Assignment assignment) {
                renderAssignmentToContext(assignment, context);
            }
        });
    }

    private void renderAssignmentToContext(Assignment assignment, StatementRenderContext context) {
        context.appendLine(
                "%s = %s;",
                assignment.getVariableName(),
                expressionRenderer.render(assignment.getValue())
        );
    }

    private void renderDeclarationToContext(VariableDeclaration declaration, StatementRenderContext context) {
        if (declaration.hasInitialValue()) {
            context.appendLine(
                    "%s %s = %s;",
                    declaration.getType().getName(),
                    declaration.getName(),
                    expressionRenderer.render(declaration.getInitialValue().get())
            );
        } else {
            context.appendLine(
                    "%s %s;",
                    declaration.getType().getName(),
                    declaration.getName()
            );
        }
    }

    private void renderLoopToContext(WhileLoop loop, StatementRenderContext context) {
        context.appendLine(
                "while (%s) {",
                expressionRenderer.render(loop.getCondition())
        );

        for (Statement statement : loop.getStatements()) {
            renderToContext(statement, context.withIncreasedIndent());
        }

        context.appendLine("}");
    }
}
