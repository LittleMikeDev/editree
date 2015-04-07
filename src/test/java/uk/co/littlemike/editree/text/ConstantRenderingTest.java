package uk.co.littlemike.editree.text;

import org.junit.Before;
import org.junit.Test;
import uk.co.littlemike.editree.language.statements.expressions.IntegerConstant;
import uk.co.littlemike.editree.language.statements.expressions.StringConstant;

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

    @Test
    public void shouldRenderEmptyString() {
        // Given
        StringConstant string = new StringConstant("");

        // When
        String text = renderer.render(string);

        // Then
        assertThat(text, equalTo("\"\""));
    }

    @Test
    public void shouldRenderString() {
        // Given
        StringConstant string = new StringConstant("Some string");

        // When
        String text = renderer.render(string);

        // Then
        assertThat(text, equalTo("\"Some string\""));
    }

    @Test
    public void shouldEscapeDoubleQuotes() {
        // Given
        StringConstant string = new StringConstant("Quote -> \" <-");

        // When
        String text = renderer.render(string);

        // Then
        assertThat(text, equalTo("\"Quote -> \\\" <-\""));
    }

    @Test
    public void shouldEscapeBackslash() {
        // Given
        StringConstant string = new StringConstant("Backslash -> \\ <-");

        // When
        String text = renderer.render(string);

        // Then
        assertThat(text, equalTo("\"Backslash -> \\\\ <-\""));
    }
}
