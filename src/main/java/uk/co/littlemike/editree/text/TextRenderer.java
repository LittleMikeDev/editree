package uk.co.littlemike.editree.text;

import uk.co.littlemike.editree.language.statements.InitialisedVariableDeclaration;
import uk.co.littlemike.editree.language.statements.VariableDeclaration;
import uk.co.littlemike.editree.language.ConstructVisitor;
import uk.co.littlemike.editree.language.statements.expressions.IntegerConstant;
import uk.co.littlemike.editree.language.statements.expressions.StringConstant;

public class TextRenderer implements ConstructVisitor {

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
    public void visit(VariableDeclaration declaration) {
        text.append(typeAndName(declaration) + ";");
    }

    @Override
    public void visit(InitialisedVariableDeclaration declaration) {
        text.append(typeAndName(declaration) + " = ");
        declaration.getInitialValue().visit(this);
        text.append(";");
    }

    private String typeAndName(VariableDeclaration declaration) {
        return declaration.getType().getName() + " " + declaration.getName();
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
