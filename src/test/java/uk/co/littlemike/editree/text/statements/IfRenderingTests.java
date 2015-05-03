package uk.co.littlemike.editree.text.statements;

import org.junit.Before;
import org.junit.Test;
import uk.co.littlemike.editree.language.expressions.BooleanConstant;
import uk.co.littlemike.editree.language.expressions.IntegerConstant;
import uk.co.littlemike.editree.language.expressions.StringConstant;
import uk.co.littlemike.editree.language.statements.Assignment;
import uk.co.littlemike.editree.language.statements.VariableDeclaration;
import uk.co.littlemike.editree.language.statements.control.IfStatement;
import uk.co.littlemike.editree.language.types.Types;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class IfRenderingTests {

    private GenericStatementRenderer renderer;

    @Before
    public void setUp() {
        renderer = new GenericStatementRenderer();
    }

    @Test
    public void renderEmptyIfBlock() {
        // Given
        IfStatement ifStatement = new IfStatement(BooleanConstant.FALSE);

        // Then
        assertThat(renderer.render(ifStatement), equalTo(
                "if (false) {\n" +
                "}\n"
        ));
    }

    @Test
    public void statementsInsideIfBlockShouldBeRenderedWithIndentation() {
        // Given
        IfStatement ifStatement = new IfStatement(
                BooleanConstant.TRUE,
                new VariableDeclaration(Types.Integer, "num"),
                new Assignment("num", new IntegerConstant(7)));

        // Then
        assertThat(renderer.render(ifStatement), equalTo(
                "if (true) {\n" +
                "    Integer num;\n" +
                "    num = 7;\n" +
                "}\n"
        ));
    }

    @Test
    public void nestedIfStatementsShouldHaveCorrectIndentation() {
        // Given
        IfStatement ifStatement = new IfStatement(
                BooleanConstant.TRUE,
                new IfStatement(
                        BooleanConstant.FALSE,
                        new VariableDeclaration("thisIsExecutable", BooleanConstant.FALSE)
                )
        );

        // Then
        assertThat(renderer.render(ifStatement), equalTo(
                "if (true) {\n" +
                "    if (false) {\n" +
                "        Boolean thisIsExecutable = false;\n" +
                "    }\n" +
                "}\n"
        ));
    }

    @Test
    public void multipleConditions() {
        // Given
        IfStatement ifStatement = new IfStatement(
                BooleanConstant.FALSE
        ).withCondition(
                BooleanConstant.TRUE,
                new VariableDeclaration(Types.Boolean, "thisIsExecutable"),
                new Assignment("thisIsExecutable", BooleanConstant.TRUE)
        );

        // Then
        assertThat(renderer.render(ifStatement), equalTo(
                "if (false) {\n" +
                "} else if (true) {\n" +
                "    Boolean thisIsExecutable;\n" +
                "    thisIsExecutable = true;\n" +
                "}\n"
        ));
    }

    @Test
    public void elseBlock() {
        // Given
        IfStatement ifStatement = new IfStatement(
                BooleanConstant.FALSE
        ).withDefault(
                new VariableDeclaration(Types.String, "greeting"),
                new Assignment("greeting", new StringConstant("Hello world!"))
        );

        // Then
        assertThat(renderer.render(ifStatement), equalTo(
                "if (false) {\n" +
                "} else {\n" +
                "    String greeting;\n" +
                "    greeting = \"Hello world!\";\n" +
                "}\n"
        ));
    }

    @Test
    public void multipleConditionsAndElseBlock() {
        // Given
        IfStatement ifStatement = new IfStatement(
                BooleanConstant.FALSE,
                new VariableDeclaration(Types.Integer, "neverHere")
        ).withCondition(
                BooleanConstant.TRUE,
                new VariableDeclaration(Types.Integer, "alwaysHere")
        ).withCondition(
                BooleanConstant.TRUE,
                new VariableDeclaration(Types.Integer, "neverHereEither")
        ).withDefault(
                new VariableDeclaration(Types.Integer, "whatDoYouThink")
        );

        // Then
        assertThat(renderer.render(ifStatement), equalTo(
                "if (false) {\n" +
                "    Integer neverHere;\n" +
                "} else if (true) {\n" +
                "    Integer alwaysHere;\n" +
                "} else if (true) {\n" +
                "    Integer neverHereEither;\n" +
                "} else {\n" +
                "    Integer whatDoYouThink;\n" +
                "}\n"
        ));
    }
}
