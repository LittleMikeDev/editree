package uk.co.littlemike.editree.text;

import uk.co.littlemike.editree.language.statements.SimpleStatement;
import uk.co.littlemike.editree.language.statements.SimpleStatementVisitor;
import uk.co.littlemike.editree.language.statements.VariableDeclaration;

public class SimpleStatementRenderer {

    private ExpressionRenderer expressionRenderer = new ExpressionRenderer();

    public String render(SimpleStatement statement) {
        StringBuilder text = new StringBuilder();
        statement.visit(new SimpleStatementVisitor() {
            @Override
            public void visit(VariableDeclaration declaration) {
                text.append(declaration.getType().getName() + " " + declaration.getName());
                declaration.getInitialValue().ifPresent((initialValue) ->
                                text.append(" = ")
                                        .append (expressionRenderer.render(initialValue))
                );
            }
        });
        return text.toString();
    }
}
