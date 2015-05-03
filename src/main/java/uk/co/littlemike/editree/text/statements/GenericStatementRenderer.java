package uk.co.littlemike.editree.text.statements;

import uk.co.littlemike.editree.language.statements.Assignment;
import uk.co.littlemike.editree.language.statements.Statement;
import uk.co.littlemike.editree.language.statements.StatementVisitor;
import uk.co.littlemike.editree.language.statements.VariableDeclaration;
import uk.co.littlemike.editree.language.statements.control.IfStatement;
import uk.co.littlemike.editree.language.statements.control.WhileLoop;
import uk.co.littlemike.editree.text.statements.control.IfRenderer;
import uk.co.littlemike.editree.text.statements.control.WhileLoopRenderer;

public class GenericStatementRenderer implements StatementRenderer<Statement> {

    private final AssignmentRenderer assignmentRenderer = new AssignmentRenderer();
    private final VariableDeclarationRenderer declarationRenderer  = new VariableDeclarationRenderer();
    private final WhileLoopRenderer whileLoopRenderer = new WhileLoopRenderer(this);
    private final IfRenderer ifRenderer = new IfRenderer(this);

    public String render(Statement statement) {
        StatementRenderContext context = new StatementRenderContext();
        renderToContext(statement, context);
        return context.getRenderedText();
    }

    @Override
    public void renderToContext(Statement statement, StatementRenderContext context) {
        statement.visit(new StatementVisitor() {
            @Override
            public void visit(VariableDeclaration declaration) {
                declarationRenderer.renderToContext(declaration, context);
            }

            @Override
            public void visit(WhileLoop loop) {
                whileLoopRenderer.renderToContext(loop, context);
            }

            @Override
            public void visit(Assignment assignment) {
                assignmentRenderer.renderToContext(assignment, context);
            }

            @Override
            public void visit(IfStatement ifStatement) {
                ifRenderer.renderToContext(ifStatement, context);
            }
        });
    }
}
