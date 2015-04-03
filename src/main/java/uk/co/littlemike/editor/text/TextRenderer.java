package uk.co.littlemike.editor.text;

import uk.co.littlemike.editor.statements.IntegerConstant;
import uk.co.littlemike.editor.statements.VariableDeclaration;

public class TextRenderer {
    public String render(IntegerConstant integer) {
        return Integer.toString(integer.getValue());
    }

    public String render(VariableDeclaration declaration) {
        return declaration.getType().getName() + " " + declaration.getName() + ";";
    }
}
