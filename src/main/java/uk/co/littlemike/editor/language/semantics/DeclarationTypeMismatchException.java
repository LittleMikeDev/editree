package uk.co.littlemike.editor.language.semantics;

import uk.co.littlemike.editor.language.types.Type;

public class DeclarationTypeMismatchException extends RuntimeException {
    public DeclarationTypeMismatchException(String variableName, Type variableType, Type expressionType) {
        super("Declaration of " + variableName + " has incompatible types. Expected: " + variableType.getName() + ", Got: " + expressionType.getName());
    }
}
