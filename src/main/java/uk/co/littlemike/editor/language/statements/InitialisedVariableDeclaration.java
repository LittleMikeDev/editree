package uk.co.littlemike.editor.language.statements;

import uk.co.littlemike.editor.language.types.Type;

public class InitialisedVariableDeclaration extends VariableDeclaration {

    private final IntegerConstant initialValue;

    public InitialisedVariableDeclaration(Type type, String name, IntegerConstant initialValue) {
        super(type, name);
        this.initialValue = initialValue;
    }

    public IntegerConstant getInitialValue() {
        return initialValue;
    }
}
