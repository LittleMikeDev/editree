package uk.co.littlemike.editree.text.expressions;

import org.junit.Before;
import org.junit.Test;
import uk.co.littlemike.editree.language.expressions.BooleanConstant;
import uk.co.littlemike.editree.language.expressions.IntegerConstant;
import uk.co.littlemike.editree.language.expressions.StringConstant;
import uk.co.littlemike.editree.text.expressions.ExpressionRenderer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ConstantRenderingTests {

    private ExpressionRenderer renderer;

    @Before
    public void setUp() {
        renderer = new ExpressionRenderer();
    }

    @Test
    public void shouldRenderIntegerConstant() {
        // Given
        IntegerConstant integer = new IntegerConstant(5);

        // Then
        assertThat(renderer.render(integer), equalTo("5"));
    }

    @Test
    public void shouldRenderNegativeIntegerConstant() {
        // Given
        IntegerConstant integer = new IntegerConstant(-3);

        // Then
        assertThat(renderer.render(integer), equalTo("-3"));
    }

    @Test
    public void shouldRenderTrueConstant() {
        // Given
        BooleanConstant bool = BooleanConstant.TRUE;

        // Then
        assertThat(renderer.render(bool), equalTo("true"));
    }

    @Test
    public void shouldRenderFalseConstant() {
        // Given
        BooleanConstant bool = BooleanConstant.FALSE;

        // Then
        assertThat(renderer.render(bool), equalTo("false"));
    }

    @Test
    public void shouldRenderEmptyString() {
        // Given
        StringConstant string = new StringConstant("");

        // Then
        assertThat(renderer.render(string), equalTo("\"\""));
    }

    @Test
    public void shouldRenderString() {
        // Given
        StringConstant string = new StringConstant("Some string");

        // Then
        assertThat(renderer.render(string), equalTo("\"Some string\""));
    }

    @Test
    public void shouldEscapeDoubleQuotes() {
        // Given
        StringConstant string = new StringConstant("Quote -> \" <-");

        // Then
        assertThat(renderer.render(string), equalTo("\"Quote -> \\\" <-\""));
    }

    @Test
    public void shouldEscapeBackslash() {
        // Given
        StringConstant string = new StringConstant("Backslash -> \\ <-");

        // Then
        assertThat(renderer.render(string), equalTo("\"Backslash -> \\\\ <-\""));
    }
}
