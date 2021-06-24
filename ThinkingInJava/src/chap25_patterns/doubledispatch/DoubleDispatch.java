package chap25_patterns.doubledispatch;
// Using multiple dispatching to handle more
// than one unknown type during a method call

import chap25_patterns.trash.*;

import java.util.*;

class AluminumBin extends TypedBin {
    @Override
    public boolean add(Aluminum a) {
        return addIt(a);
    }
}

class PaperBin extends TypedBin {
    @Override
    public boolean add(Paper a) {
        return addIt(a);
    }
}

class GlassBin extends TypedBin {
    @Override
    public boolean add(Glass a) {
        return addIt(a);
    }
}

class CardboardBin extends TypedBin {
    @Override
    public boolean add(Cardboard a) {
        return addIt(a);
    }
}

class TrashBinSet {
    private List<TypedBin> binSet = Arrays.asList(
            new AluminumBin(),
            new PaperBin(),
            new GlassBin(),
            new CardboardBin()
    );

    @SuppressWarnings("unchecked")
    public void sortIntoBins(List bin) {
        bin.forEach(aBin -> {
            TypedBinMember t = (TypedBinMember) aBin;
            if (!t.addToBin(binSet))
                System.err.println("Couldn't add " + t);
        });
    }

    public List<TypedBin> binSet() {
        return binSet;
    }
}

public class DoubleDispatch {
    public static void main(String[] args) {
        List<Trash> bin = new ArrayList<>();
        TrashBinSet bins = new TrashBinSet();
        // ParseTrash still works, without changes:
        ParseTrash.fillBin("doubledispatch", bin);
        // Sort from the master bin into the
        // individually-typed bins:
        bins.sortIntoBins(bin);
        // Perform sumValue for each bin...
        bins.binSet()
                .forEach(tb -> Trash.sumValue(tb.v));
        // ... and for the master bin
        Trash.sumValue(bin);
    }
}
