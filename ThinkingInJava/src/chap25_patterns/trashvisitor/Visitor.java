package chap25_patterns.trashvisitor;

public interface Visitor {
    void visit(Aluminum a);

    void visit(Paper p);

    void visit(Glass g);

    void visit(Cardboard c);

    void total();
}
