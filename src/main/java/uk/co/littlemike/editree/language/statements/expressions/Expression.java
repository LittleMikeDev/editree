package uk.co.littlemike.editree.language.statements.expressions;

import uk.co.littlemike.editree.language.Construct;
import uk.co.littlemike.editree.language.types.Type;

public interface Expression extends Construct {
    public Type getType();
}
