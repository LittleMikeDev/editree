package uk.co.littlemike.editree.text;

import uk.co.littlemike.editree.language.expressions.*;

public class ExpressionRenderer {

    public String render(Expression expression) {
        StringBuilder text = new StringBuilder();
        expression.visit(new ExpressionVisitor() {
            @Override
            public void visit(IntegerConstant integer) {
                text.append(Integer.toString(integer.getValue()));
            }

            @Override
            public void visit(StringConstant string) {
                text.append('"' + escapeQuotesAndSlashes(string) + '"');
            }

            @Override
            public void visit(BooleanConstant booleanConstant) {
                text.append(Boolean.toString(booleanConstant.getValue()));
            }
        });
        return text.toString();
    }

    private String escapeQuotesAndSlashes(StringConstant string) {
        return string.getValue()
                .replace("\\", "\\\\")
                .replace("\"", "\\\"");
    }
}
