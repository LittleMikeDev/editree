package uk.co.littlemike.editree.text;

import org.apache.commons.lang3.StringUtils;

public class StatementRenderContext {
    private static final String INDENTATION = "    ";

    private int indent = 0;
    private final StringBuilder text = new StringBuilder();

    public void increaseIndent() {
        indent++;
    }

    public void decreaseIndent() {
        indent--;
    }

    public void appendLine(String line) {
        text.append(StringUtils.repeat(INDENTATION, indent)).append(line).append('\n');
    }

    public String getRenderedText() {
        return text.toString();
    }
}
