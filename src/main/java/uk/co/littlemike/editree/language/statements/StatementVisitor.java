package uk.co.littlemike.editree.language.statements;

public interface StatementVisitor {

    public void visit(VariableDeclaration declaration);

    public void visit(InitialisedVariableDeclaration declaration);
}
