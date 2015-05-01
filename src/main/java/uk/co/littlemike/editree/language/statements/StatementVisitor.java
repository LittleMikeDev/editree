package uk.co.littlemike.editree.language.statements;

import uk.co.littlemike.editree.language.statements.control.WhileLoop;

public interface StatementVisitor {

    public void visit(VariableDeclaration declaration);

    public void visit(WhileLoop loop);

    public void visit(Assignment assignment);
}
