package chap20_generics;

import onjava.*;

class TupleTest {
    static Tuple2<String, Integer> f() {
        // Autoboxing converts the int to Integer:
        return new Tuple2<>("hi", 47);
    }

    static Tuple3<Amphibian, String, Integer> g() {
        return new Tuple3<>(new Amphibian(), "hi", 47);
    }

    static Tuple4<Vehicle, Amphibian, String, Integer> h() {
        return
                new Tuple4<>(
                        new Vehicle(), new Amphibian(), "hi", 47);
    }

    static Tuple5<Vehicle, Amphibian,
            String, Integer, Double> k() {
        return new
                Tuple5<>(
                new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        Tuple2<String, Integer> ttsi = f();
        System.out.println(ttsi);
        // ttsi.a1 = "there"; // Compile error: final
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}

public class A01_TupleTest {
}
