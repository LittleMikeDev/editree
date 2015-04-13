package uk.co.littlemike.editree.language;

import uk.co.littlemike.editree.language.statements.InitialisedVariableDeclaration;
import uk.co.littlemike.editree.language.statements.VariableDeclaration;
import uk.co.littlemike.editree.language.statements.expressions.IntegerConstant;
import uk.co.littlemike.editree.language.statements.expressions.StringConstant;
import uk.co.littlemike.editree.language.structures.Block;

public interface ConstructVisitor {

    public void visit(IntegerConstant integerConstant);

    public void visit(StringConstant stringConstant);

    public void visit(VariableDeclaration declaration);

    public void visit(InitialisedVariableDeclaration declaration);

    public void visit(Block block);
}
