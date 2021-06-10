package chap20_generics;

import java.util.*;

class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit()); // Error
    }
}

public class A08_SuperTypeWildcards {
}
