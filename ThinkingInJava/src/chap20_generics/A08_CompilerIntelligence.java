package chap20_generics;

import java.util.*;

class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist =
                Arrays.asList(new Apple());

        // error:
//        flist.add(new Apple());
        System.out.println(flist);

        Apple a = (Apple) flist.get(0); // No warning
        System.out.println(
                flist.contains(new Apple()) // Argument is 'Object'
        );
        System.out.println(
                flist.indexOf(new Apple()) // Argument is 'Object'
        );
    }
}

public class A08_CompilerIntelligence {
}
