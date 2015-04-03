package uk.co.littlemike.editor.semantics;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import uk.co.littlemike.editor.language.semantics.DeclarationTypeMismatchException;
import uk.co.littlemike.editor.language.statements.InitialisedVariableDeclaration;
import uk.co.littlemike.editor.language.statements.StringConstant;
import uk.co.littlemike.editor.language.types.Types;

public class TypeMismatchTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldNotBeAbleToInitialiseVariableWithExpressionWithIncorrectType() {
        // Given
        StringConstant string = new StringConstant("Hello world!");

        // Expect
        exception.expect(DeclarationTypeMismatchException.class);
        exception.expectMessage("Declaration of myVar has incompatible types. Expected: Integer, Got: String");

        // When
        new InitialisedVariableDeclaration(Types.Integer, "myVar", string);
    }
}
