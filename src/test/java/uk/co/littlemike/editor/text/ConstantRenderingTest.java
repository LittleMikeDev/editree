package uk.co.littlemike.editor.text;

import org.junit.Before;
import org.junit.Test;
import uk.co.littlemike.editor.statements.IntegerConstant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ConstantRenderingTest {

    private TextRenderer renderer;

    @Before
    public void setUp() {
        renderer = new TextRenderer();
    }

    @Test
    public void shouldRenderIntegerConstant() {
        // Given
        IntegerConstant integer = new IntegerConstant(5);

        // When
        String text = renderer.render(integer);

        // Then
        assertThat(text, equalTo("5"));
    }

    @Test
    public void shouldRenderNegativeIntegerConstant() {
        // Given
        IntegerConstant integer = new IntegerConstant(-3);

        // When
        String text = renderer.render(integer);

        // Then
        assertThat(text, equalTo("-3"));
    }
}
