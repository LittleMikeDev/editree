package uk.co.littlemike.editree.language.statements.structures;

import uk.co.littlemike.editree.language.statements.SimpleStatement;

import java.util.Arrays;
import java.util.List;

public class Block {

    private final List<SimpleStatement> statements;

    public Block(SimpleStatement... statements) {
        this.statements = Arrays.asList(statements);
    }

    public boolean isEmpty() {
        return statements.isEmpty();
    }

    public List<SimpleStatement> getStatements() {
        return statements;
    }
}
