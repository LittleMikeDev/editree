package uk.co.littlemike.editor.language.statements;

public class StringConstant {

    private final String value;

    public StringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
