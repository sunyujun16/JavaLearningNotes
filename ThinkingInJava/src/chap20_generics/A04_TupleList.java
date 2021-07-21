package chap20_generics;

// Combining generic types to make complex generic types

import java.util.*;

import onjava.*;

import java.util.stream.*;

// ArrayList的泛型参数可以删除, 那么它在这里有什么用呢?
// 删除后,其实第三句就能执行了,这是因为第一个<A, B, C, D>只是参数而已
// ,用来设定ABCD的类型, 但实际存储类型是由ArrayList<>来控制的,所以有用.
class TupleList<A, B, C, D> extends ArrayList<Tuple4<A, B, C, D>> {
    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> tl =
                new TupleList<>();
        tl.add(TupleTest2.h());
        tl.add(TupleTest2.h());
//        tl.add(TupleTest2.h2());  // 类型顺序匹配失败, 编译器鸡贼的很.
        tl.forEach(System.out::println);
    }
}

// 存什么都行,不受控制了.泛型参数在这里毫无意义,存储类型变成了默认的Object.
// 也可以看到调用方法时, 编译器都提醒类型是不受检查的.
class TupleListMy<A, B, C, D> extends ArrayList {
    public static void main(String[] args) {
        TupleListMy<Vehicle, Amphibian, String, Integer> tl =
                new TupleListMy<>();
        tl.add(TupleTest2.h());
        tl.add(TupleTest2.h());
        tl.add(TupleTest2.h2());
        tl.add("asdf");

        tl.forEach(System.out::println);


        ArrayList objects = new ArrayList();
        objects.add(1);
        objects.add("haha");
        objects.stream().forEach(System.out::println);
    }
}

public class A04_TupleList {
}
