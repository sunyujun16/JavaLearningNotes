package chap19_typeinfo;

import java.util.stream.*;
import java.nio.file.*;

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    void rotate() {
        System.out.println(this + " 转圈圈");
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

class Rhomboid extends Shape {
    @Override
    public String toString() {
        return "Rhomboid";
    }
}

public class A01_Shapes {
    public static void main(String[] args) {
        Stream.of(
                new Circle(), new Square(), new Triangle())
                .forEach(Shape::draw);
        System.out.println("here");

        Shape s = new Rhomboid();
        Rhomboid rh = (Rhomboid) s;
        System.out.println(s instanceof Rhomboid);
        if(s instanceof Circle) {
            Circle cl = (Circle) s;
        } else System.out.println("滚犊子吧哈哈哈哈哈");
        Stream.of(
                new Circle(), new Square(), new Triangle())
                .filter(ss -> !(ss instanceof Circle))
                .forEach(Shape::rotate);

    }
}
