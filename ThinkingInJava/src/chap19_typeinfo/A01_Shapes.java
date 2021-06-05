package chap19_typeinfo;

import java.util.stream.*;
import java.nio.file.*;

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    @Override
    public abstract String toString();
}

class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle";
    }
}

public class A01_Shapes {
    public static void main(String[] args) {
        Stream.of(
                new Circle(), new Square(), new Triangle())
                .forEach(Shape::draw);
        System.out.println("here");
        Path p = Paths.get("");

    }
}
