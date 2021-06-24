package chap25_patterns.doubledispatch;

import chap25_patterns.trash.*;

import java.util.*;

public class Aluminum extends chap25_patterns.trash.Aluminum
        implements TypedBinMember {
    public Aluminum(double wt) {
        super(wt);
    }

    @Override
    public boolean addToBin(List<TypedBin> tbins) {
        return tbins.stream()
                .anyMatch(tb -> tb.add(this));
    }
}
