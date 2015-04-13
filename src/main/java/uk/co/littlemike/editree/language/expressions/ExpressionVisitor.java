package uk.co.littlemike.editree.language.expressions;

public interface ExpressionVisitor {

    public void visit(IntegerConstant integerConstant);

    public void visit(StringConstant stringConstant);

    public void visit(BooleanConstant booleanConstant);
}
