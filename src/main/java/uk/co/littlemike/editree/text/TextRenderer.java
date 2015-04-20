package uk.co.littlemike.editree.text;

import uk.co.littlemike.editree.language.expressions.BooleanConstant;
import uk.co.littlemike.editree.language.expressions.ExpressionVisitor;
import uk.co.littlemike.editree.language.expressions.IntegerConstant;
import uk.co.littlemike.editree.language.expressions.StringConstant;
import uk.co.littlemike.editree.language.statements.VariableDeclaration;
import uk.co.littlemike.editree.language.statements.Statement;
import uk.co.littlemike.editree.language.statements.StatementVisitor;
import uk.co.littlemike.editree.language.statements.structures.Block;

public class TextRenderer implements ExpressionVisitor, StatementVisitor {

    private StringBuilder text = new StringBuilder();

    @Override
    public void visit(IntegerConstant integer) {
        text.append(Integer.toString(integer.getValue()));
    }

    @Override
    public void visit(StringConstant string) {
        text.append('"' + escapeQuotesAndSlashes(string) + '"');
    }

    @Override
    public void visit(BooleanConstant booleanConstant) {
        text.append(Boolean.toString(booleanConstant.getValue()));
    }

    @Override
    public void visit(VariableDeclaration declaration) {
        text.append(declaration.getType().getName() + " " + declaration.getName());
        declaration.getInitialValue().ifPresent((initialValue) -> {
                text.append(" = ");
                initialValue.visit(this);
        });
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

    private String escapeQuotesAndSlashes(StringConstant string) {
        return string.getValue()
                .replace("\\", "\\\\")
                .replace("\"", "\\\"");
    }

    public String getText() {
        return text.toString();
    }
}
