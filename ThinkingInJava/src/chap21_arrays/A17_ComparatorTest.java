package chap21_arrays;

// Implementing a Comparator for a class

import onjava.*;

import java.util.Arrays;
import java.util.Comparator;

import static onjava.ArrayShow.*;

class CompTypeComparator implements Comparator<CompType> {
    @Override
    public int compare(CompType o1, CompType o2) {
        return (o1.j < o2.j ? -1 : (o1.j == o2.j ? 0 : 1));
    }
}

class ComparatorTest {
    public static void main(String[] args) {
        CompType[] a = new CompType[12];
        Arrays.setAll(a, n -> CompType.get());
        show("Before sorting", a);
        Arrays.sort(a, new CompTypeComparator());
        show("After sorting", a);
    }
}

public class A17_ComparatorTest {
}
