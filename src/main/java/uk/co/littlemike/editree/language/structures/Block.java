package uk.co.littlemike.editree.language.structures;

import uk.co.littlemike.editree.language.statements.Statement;

import java.util.Arrays;
import java.util.List;

public class Block {

    private final List<Statement> statements;

    public Block(Statement... statements) {
        this.statements = Arrays.asList(statements);
    }

    public boolean isEmpty() {
        return statements.isEmpty();
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
