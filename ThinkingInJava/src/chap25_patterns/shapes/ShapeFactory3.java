package chap25_patterns.shapes;

// Polymorphic factory methods

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

//import patterns.shapes.*;
interface PolymorphicFactory {
    Shape create();
}

class RandomShapes implements Supplier<Shape> {
    private final PolymorphicFactory[] factories;
    private Random rand = new Random(42);

    RandomShapes(PolymorphicFactory... factories) {
        this.factories = factories;
    }

    public Shape get() {
        return factories[rand.nextInt(factories.length)]
                .create();
    }
}

public class ShapeFactory3 {
    public static void main(String[] args) {
        RandomShapes rs = new RandomShapes(
                Circle::new, Square::new, Triangle::new
        ); // 孩子, 你要慢慢习惯, 把new看作一个静态方法.
        Stream.generate(rs)
                .limit(6)
                .peek(Shape::draw)
                .peek(Shape::erase)
                .count();
    }
}
