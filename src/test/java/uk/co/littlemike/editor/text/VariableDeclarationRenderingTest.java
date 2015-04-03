package uk.co.littlemike.editor.text;

import org.junit.Before;
import org.junit.Test;
import uk.co.littlemike.editor.language.statements.VariableDeclaration;
import uk.co.littlemike.editor.language.types.Types;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class VariableDeclarationRenderingTest {

    private TextRenderer renderer;

    @Before
    public void setUp() {
        renderer = new TextRenderer();
    }

    @Test
    public void shouldRenderUninitialisedIntegerDeclaration() {
        // Given
        VariableDeclaration declaration = new VariableDeclaration(Types.Integer, "myVariable");

        // When
        String text = renderer.render(declaration);

        // Then
        assertThat(text, equalTo("Integer myVariable;"));
    }

    @Test
    public void shouldRenderUninitialisedStringDeclaration() {
        // Given
        VariableDeclaration declaration = new VariableDeclaration(Types.String, "myString");

        // When
        String text = renderer.render(declaration);

        // Then
        assertThat(text, equalTo("String myString;"));
    }
}
