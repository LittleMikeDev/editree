package uk.co.littlemike.editree.text;

import uk.co.littlemike.editree.language.statements.InitialisedVariableDeclaration;
import uk.co.littlemike.editree.language.statements.expressions.IntegerConstant;
import uk.co.littlemike.editree.language.statements.expressions.StringConstant;
import uk.co.littlemike.editree.language.statements.VariableDeclaration;
import uk.co.littlemike.editree.language.statements.expressions.Expression;

public class TextRenderer {
    public String render(Expression expression) {
        if (expression instanceof IntegerConstant) {
            return render((IntegerConstant) expression);
        }
        if (expression instanceof StringConstant) {
            return render((StringConstant) expression);
        }
        return "";
    }

    public String render(IntegerConstant integer) {
        return Integer.toString(integer.getValue());
    }

    public String render(VariableDeclaration declaration) {
        return renderTypeAndName(declaration) + ";";
    }

    public String render(InitialisedVariableDeclaration declaration) {
        return renderTypeAndName(declaration) + " = " + render(declaration.getInitialValue()) + ";";
    }

    private String renderTypeAndName(VariableDeclaration declaration) {
        return declaration.getType().getName() + " " + declaration.getName();
    }

    public String render(StringConstant string) {
        return '"' + escapeQuotesAndSlashes(string) + '"';
    }

    private String escapeQuotesAndSlashes(StringConstant string) {
        return string.getValue()
                .replace("\\", "\\\\")
                .replace("\"", "\\\"");
    }
}
