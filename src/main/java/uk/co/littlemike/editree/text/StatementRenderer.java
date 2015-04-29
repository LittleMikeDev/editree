package uk.co.littlemike.editree.text;

import uk.co.littlemike.editree.language.statements.SimpleStatement;
import uk.co.littlemike.editree.language.statements.control.WhileLoop;

public class StatementRenderer {
    private final ExpressionRenderer conditionRenderer = new ExpressionRenderer();
    private final SimpleStatementRenderer simpleStatementRenderer = new SimpleStatementRenderer();

    public String render(WhileLoop loop) {
        StringBuilder text = new StringBuilder();
        text.append("while (")
            .append(conditionRenderer.render(loop.getCondition()))
            .append(") {\n");

        for (SimpleStatement statement : loop.getStatements()) {
            text.append("    ")
                .append(simpleStatementRenderer.render(statement))
                .append(";\n");
        }

        text.append("}");
        return text.toString();
    }
}
