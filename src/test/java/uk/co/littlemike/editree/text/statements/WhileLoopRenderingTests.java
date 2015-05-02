package uk.co.littlemike.editree.text.statements;

import org.junit.Before;
import org.junit.Test;
import uk.co.littlemike.editree.language.expressions.BooleanConstant;
import uk.co.littlemike.editree.language.statements.VariableDeclaration;
import uk.co.littlemike.editree.language.statements.control.WhileLoop;
import uk.co.littlemike.editree.language.types.Types;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WhileLoopRenderingTests {

    private GenericStatementRenderer renderer;

    @Before
    public void setUp() {
        renderer = new GenericStatementRenderer();
    }

    @Test
    public void renderEmptyWhileLoop() {
        // Given
        WhileLoop loop = new WhileLoop(BooleanConstant.TRUE);

        // Then
        assertThat(renderer.render(loop), equalTo(
                "while (true) {\n" +
                "}\n"
        ));
    }

    @Test
    public void statementsInWhileLoopShouldBeIndentedAndTerminatedInSequence() {
        // Given
        WhileLoop loop = new WhileLoop(
                BooleanConstant.FALSE,
                new VariableDeclaration(Types.Boolean, "aBool"),
                new VariableDeclaration(Types.Integer, "anInt"));

        // Then
        assertThat(renderer.render(loop), equalTo(
                "while (false) {\n" +
                "    Boolean aBool;\n" +
                "    Integer anInt;\n" +
                "}\n"
        ));
    }

    @Test
    public void nestedWhileLoopsShouldHaveDoubleIndentation() {
        // Given
        WhileLoop loop = new WhileLoop(
                BooleanConstant.FALSE,
                new WhileLoop(BooleanConstant.TRUE,
                        new VariableDeclaration(Types.Integer, "anInt"))
        );

        // Then
        assertThat(renderer.render(loop), equalTo(
                "while (false) {\n" +
                "    while (true) {\n" +
                "        Integer anInt;\n" +
                "    }\n" +
                "}\n"
        ));
    }
}
