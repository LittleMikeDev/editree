package uk.co.littlemike.editree.text;

import uk.co.littlemike.editree.language.statements.SimpleStatement;
import uk.co.littlemike.editree.language.statements.structures.Block;

public class BlockRenderer {
    SimpleStatementRenderer simpleStatementRenderer = new SimpleStatementRenderer();

    public void render(StringBuilder text, Block block) {
        if (block.isEmpty()) {
            text.append("{ }\n");
        }
        else {
            text.append("{\n");
            renderStatements(text, block.getStatements());
            text.append("}\n");
        }
    }

    private void renderStatements(StringBuilder text, Iterable<SimpleStatement> statements) {
        for (SimpleStatement statement : statements) {
            text.append(simpleStatementRenderer.render(statement))
                .append('\n');
        }
    }
}
