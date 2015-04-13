package uk.co.littlemike.editree.language.structures;

import uk.co.littlemike.editree.language.Construct;
import uk.co.littlemike.editree.language.ConstructVisitor;
import uk.co.littlemike.editree.language.statements.Statement;

import java.util.Arrays;
import java.util.List;

public class Block implements Construct {

    private final List<Statement> statements;

    public Block(Statement... statements) {
        this.statements = Arrays.asList(statements);
    }

    @Override
    public void visit(ConstructVisitor visitor) {
        visitor.visit(this);
    }

    public boolean isEmpty() {
        return statements.isEmpty();
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
