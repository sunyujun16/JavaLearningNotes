package chap20_generics;

import java.util.*;

class CompilerIntelligence {
    public static void main(String[] args) {
        Apple apl = new Apple();

        List<? extends Fruit> flist =
                Arrays.asList(apl);

        // error:
//        flist.add(new Apple());

        // 但是可以这样修改. 编译器就心里有di了.
        List<? super Fruit> flist2 =
                Arrays.asList(apl);
        flist2.add(new Apple());


        System.out.println(flist);

        Apple a = (Apple) flist.get(0); // No warning
        System.out.println(
                flist.contains(apl) // Argument is 'Object'
        );
        System.out.println(
                flist.indexOf(new Apple()) // Argument is 'Object'
        );
    }
}

public class A08_CompilerIntelligence {
}
