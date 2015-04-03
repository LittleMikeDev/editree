package uk.co.littlemike.editor.text;

import uk.co.littlemike.editor.statements.IntegerConstant;

public class TextRenderer {
    public String render(IntegerConstant integer) {
        return Integer.toString(integer.getValue());
    }
}
