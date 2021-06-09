package chap20_generics;

// Combining generic types to make complex generic types

import java.util.*;

import onjava.*;

import java.util.stream.*;

class TupleList<A, B, C, D> extends ArrayList<Tuple4<A, B, C, D>> {
    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> tl =
                new TupleList<>();
        tl.add(TupleTest2.h());
        tl.add(TupleTest2.h());
//        tl.add(TupleTest2.h2());  // 失败, 编译器鸡贼的很.
        tl.forEach(System.out::println);
    }
}

public class A04_TupleList {
}
