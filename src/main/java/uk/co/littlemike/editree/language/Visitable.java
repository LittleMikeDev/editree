package uk.co.littlemike.editree.language;

public interface Visitable<VisitorType> {

    public void visit(VisitorType visitor);
}
