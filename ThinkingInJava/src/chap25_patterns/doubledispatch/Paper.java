package chap25_patterns.doubledispatch;

import chap25_patterns.trash.*;

import java.util.*;

public class Paper extends chap25_patterns.trash.Paper
        implements TypedBinMember {
    public Paper(double wt) {
        super(wt);
    }

    @Override
    public boolean addToBin(List<TypedBin> tbins) {
        return tbins.stream()
                .anyMatch(tb -> tb.add(this));
    }
}
