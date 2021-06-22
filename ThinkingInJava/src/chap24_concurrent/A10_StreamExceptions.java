package chap24_concurrent;

import java.util.concurrent.*;
import java.util.stream.*;

class StreamExceptions {
    static Stream<Breakable>
    test(String id, int failcount) {
        return
                Stream.of(new Breakable(id, failcount))
                        .map(Breakable::work)
                        .map(Breakable::work)
                        .map(Breakable::work)
                        .map(Breakable::work);
    }

    public static void main(String[] args) {

        // No operations are even applied ... 所有流按兵不动.
        test("A", 1);
        test("B", 2);
        Stream<Breakable> c = test("C", 3);
        test("D", 4);
        test("E", 5);

        // ... until there's a terminal operation:
        System.out.println("Entering try");
//        try {
            c.forEach(System.out::println); // [1]
            // forEach出现之前整个流都没有执行.
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

//        System.out.println("\n");
//
//        Stream.of(new Breakable("我自己", 3))
//                .map(Breakable::work)
//                .map(Breakable::work)
//                .map(Breakable::work)
//                .map(Breakable::work)
////                .peek(ob -> System.out.println(ob.id + "这里这里这里."))
//                .forEach(System.out::println);
        // 把throw注释掉就清楚了, Stream不保存中间状态, 但在peek或forEach出现之前
        // 前面的都憋着呢, 根本没运行. 看来还是对流理解不到位.

    }
}

public class A10_StreamExceptions {
}
