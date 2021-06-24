package chap25_patterns.trashvisitor;

import chap25_patterns.trash.*;

public class Glass extends chap25_patterns.trash.Glass
        implements Visitable {
    public Glass(double wt) {
        super(wt);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
