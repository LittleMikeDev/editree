package uk.co.littlemike.editree.text;

import org.junit.Before;
import org.junit.Test;
import uk.co.littlemike.editree.language.statements.InitialisedVariableDeclaration;
import uk.co.littlemike.editree.language.statements.VariableDeclaration;
import uk.co.littlemike.editree.language.expressions.IntegerConstant;
import uk.co.littlemike.editree.language.statements.structures.Block;
import uk.co.littlemike.editree.language.types.Types;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BlockRenderingTests {

    private TextRenderer renderer;

    @Before
    public void setUp() {
        renderer = new TextRenderer();
    }

    @Test
    public void shouldRenderEmptyBlock() {
        // Given
        Block block = new Block();

        // When
        renderer.visit(block);

        // Then
        assertThat(renderer.getText(), equalTo("{ }\n"));
    }

    @Test
    public void shouldRenderBlockWithSingleStatement() {
        // Given
        VariableDeclaration declaration = new VariableDeclaration(Types.Integer, "myInt");
        Block block = new Block(declaration);

        // When
        renderer.visit(block);

        // Then
        assertThat(renderer.getText(), equalTo("{\n" +
                "Integer myInt;\n" +
                "}\n"));
    }

    @Test
    public void shouldRenderBlockWithMultipleStatements() {
        // Given
        Block block = new Block(
                new InitialisedVariableDeclaration(Types.Integer, "myInt", new IntegerConstant(2)),
                new VariableDeclaration(Types.String, "myString"));

        // When
        renderer.visit(block);

        // Then
        assertThat(renderer.getText(), equalTo("{\n" +
                "Integer myInt = 2;\n" +
                "String myString;\n" +
                "}\n"));
    }
}
