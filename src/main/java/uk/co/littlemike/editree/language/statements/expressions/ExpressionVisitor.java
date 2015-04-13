package uk.co.littlemike.editree.language.statements.expressions;

public interface ExpressionVisitor {

    public void visit(IntegerConstant integerConstant);

    public void visit(StringConstant stringConstant);
}
