package uk.co.littlemike.editree.text.statements;

public interface StatementRenderer<StatementType> {

    public void renderToContext(StatementType statement, StatementRenderContext context);
}
