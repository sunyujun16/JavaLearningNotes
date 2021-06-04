package chap19_typeinfo;

import onjava.*;

import java.util.*;

public interface A08_Robot {
    String name();

    String model();

    List<A08_Operation> operations();

    // 接口里放通用代码,接收其实现类型, 请问这属于什么设计模式? 答: 不知道呢还...模板?
    static void test(A08_Robot r) {
        if (r instanceof Null)
            System.out.println("[Null Robot]");
        System.out.println("Robot name: " + r.name());
        System.out.println("Robot model: " + r.model());

        for (A08_Operation operation : r.operations()) {
            System.out.println(operation.description.get());
            operation.command.run();
        }
    }
}
