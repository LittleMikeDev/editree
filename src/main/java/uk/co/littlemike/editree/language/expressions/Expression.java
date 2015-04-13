package uk.co.littlemike.editree.language.expressions;

import uk.co.littlemike.editree.language.Visitable;
import uk.co.littlemike.editree.language.types.Type;

public interface Expression extends Visitable<ExpressionVisitor> {
    public Type getType();
}
