package chap20_generics;

import onjava.*;

import static onjava.Tuple.*;

class TupleTest2 {
    static Tuple2<String, Integer> f() {
        return tuple("hi", 47);
    }

    // 不强制显式指出类型
    static Tuple2 f2() {
        return tuple("hi", 47);
    }

    static Tuple3<Amphibian, String, Integer> g() {
        return tuple(new Amphibian(), "hi", 47);
    }

    static Tuple4<Vehicle, Amphibian, String, Integer> h() {
        return tuple(
                new Vehicle(), new Amphibian(), "hi", 47);
    }

    static Tuple4< Amphibian,Vehicle, String, Integer> h2() {
        return tuple(
                new Amphibian(), new Vehicle(), "hi", 47);
    }

    static Tuple5<Vehicle, Amphibian,
            String, Integer, Double> k() {
        return tuple(new Vehicle(), new Amphibian(),
                "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        Tuple2<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(ttsi.getClass().getCanonicalName());

        Tuple2<String, Integer> ttsi2 = f2();
        System.out.println(ttsi2);
        System.out.println(ttsi2.getClass().getCanonicalName());

        System.out.println(f2());

        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}

public class A03_TupleTest2 {
}
