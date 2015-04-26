package uk.co.littlemike.editree.text;

import uk.co.littlemike.editree.language.statements.Statement;
import uk.co.littlemike.editree.language.statements.StatementVisitor;
import uk.co.littlemike.editree.language.statements.VariableDeclaration;
import uk.co.littlemike.editree.language.statements.structures.Block;

public class TextRenderer implements StatementVisitor {

    private ExpressionRenderer expressionRenderer = new ExpressionRenderer();
    private StringBuilder text = new StringBuilder();

    @Override
    public void visit(VariableDeclaration declaration) {
        text.append(declaration.getType().getName() + " " + declaration.getName());
        declaration.getInitialValue().ifPresent((initialValue) ->
                text.append(" = ")
                    .append (expressionRenderer.render(initialValue))
        );
        text.append(";");
    }

    public void visit(Block block) {
        if (block.isEmpty()) {
            text.append("{ }\n");
        }
        else {
            text.append("{\n");
            renderStatements(block.getStatements());
            text.append("}\n");
        }
    }

    private void renderStatements(Iterable<Statement> statements) {
        for (Statement statement : statements) {
            statement.visit(this);
            text.append('\n');
        }
    }

    public String getText() {
        return text.toString();
    }
}
