package chap20_generics;

class Hamster extends ComparablePet
        implements Comparable<ComparablePet> {
    public int compareTo(ComparablePet arg) {
        return 0;
    }
}

// Or just:
class Gecko extends ComparablePet {
    public int compareTo(ComparablePet arg) {
        return 0;
    }
}

public class A09_RestrictedComparablePets {
}
