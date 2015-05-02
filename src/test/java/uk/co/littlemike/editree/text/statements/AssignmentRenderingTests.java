package uk.co.littlemike.editree.text.statements;

import org.junit.Before;
import org.junit.Test;
import uk.co.littlemike.editree.language.expressions.BooleanConstant;
import uk.co.littlemike.editree.language.expressions.StringConstant;
import uk.co.littlemike.editree.language.statements.Assignment;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AssignmentRenderingTests {
    private GenericStatementRenderer renderer;

    @Before
    public void setUp() {
        renderer = new GenericStatementRenderer();
    }

    @Test
    public void shouldRenderBooleanAssignment() {
        // Given
        Assignment assignment = new Assignment("myVar", BooleanConstant.TRUE);

        // Then
        assertThat(renderer.render(assignment), equalTo("myVar = true;\n"));
    }

    @Test
    public void shouldRenderStringAssignment() {
        // Given
        Assignment assignment = new Assignment("myVar", new StringConstant("Hi"));

        // Then
        assertThat(renderer.render(assignment), equalTo("myVar = \"Hi\";\n"));
    }
}
