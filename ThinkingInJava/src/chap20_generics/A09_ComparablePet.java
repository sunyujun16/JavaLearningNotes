package chap20_generics;

class ComparablePet
        implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet arg) {
        return 0;
    }
}

public class A09_ComparablePet {
}
