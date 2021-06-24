package chap25_patterns.doubledispatch;

import chap25_patterns.trash.*;

import java.util.*;

public class Cardboard extends chap25_patterns.trash.Cardboard
        implements TypedBinMember {
    public Cardboard(double wt) {
        super(wt);
    }

    @Override
    public boolean addToBin(List<TypedBin> tbins) {
        return tbins.stream()
                .anyMatch(tb -> tb.add(this));
    }
}
