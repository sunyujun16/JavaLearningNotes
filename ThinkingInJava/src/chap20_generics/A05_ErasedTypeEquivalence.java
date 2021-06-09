package chap20_generics;

import java.util.*;

class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }
}

public class A05_ErasedTypeEquivalence {
}
