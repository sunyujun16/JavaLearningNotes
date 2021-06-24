package chap25_patterns.trashvisitor;

// An interface to add visitor functionality to the
// Trash hierarchy without modifying the base class
public interface Visitable {
    // The new method:
    void accept(Visitor v);
}
