package chap25_patterns.trashvisitor;

import chap25_patterns.trash.*;

public class Aluminum extends chap25_patterns.trash.Aluminum
        implements Visitable {
    public Aluminum(double wt) {
        super(wt);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
