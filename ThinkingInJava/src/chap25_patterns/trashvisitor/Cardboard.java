package chap25_patterns.trashvisitor;

import chap25_patterns.trash.*;
public class Cardboard extends chap25_patterns.trash.Cardboard
        implements Visitable {
    public Cardboard(double wt) { super(wt); }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
