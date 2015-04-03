package uk.co.littlemike.editor.language.statements;

import uk.co.littlemike.editor.language.types.Type;

public class VariableDeclaration {
    private final Type type;
    private final String name;

    public VariableDeclaration(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
