package uk.co.littlemike.editree.text.statements;

import org.apache.commons.lang3.StringUtils;

public class StatementRenderContext {
    private static final String INDENTATION = "    ";

    private final int indent;
    private final StringBuilder text;

    public StatementRenderContext() {
        this(new StringBuilder(), 0);
    }

    private StatementRenderContext(StringBuilder text, int indent) {
        this.text = text;
        this.indent = indent;
    }

    public void appendLine(String line, Object... args) {
        text.append(StringUtils.repeat(INDENTATION, indent))
                .append(String.format(line, args))
                .append('\n');
    }

    public String getRenderedText() {
        return text.toString();
    }

    public StatementRenderContext withIncreasedIndent() {
        return new StatementRenderContext(text, indent + 1);
    }
}
