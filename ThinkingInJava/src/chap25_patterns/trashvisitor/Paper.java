package chap25_patterns.trashvisitor;

import chap25_patterns.trash.*;

public class Paper extends chap25_patterns.trash.Paper
        implements Visitable {
    public Paper(double wt) {
        super(wt);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
