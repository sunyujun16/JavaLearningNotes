package chap25_patterns.shapes;

import java.util.stream.*;

public class FactoryTest {
    public static void test(FactoryMethod factory) {
        Stream.of("Circle", "Square", "Triangle",
                "Square", "Circle", "Circle", "Triangle")
                .map(factory::create)
                .peek(Shape::draw)
                .peek(Shape::erase)
                .forEach((a)->{})
//                .count()
        ; // Terminal operation
        // 似乎是编译器变聪明了, 流元素如果不用一下, 根本就不执行流中间操作.
    }
}
