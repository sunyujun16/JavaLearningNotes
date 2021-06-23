package chap25_patterns.shapes;

// A simple static factory method

import java.util.*;
import java.util.stream.*;
//import chap25_patterns.shapes.*;

public class ShapeFactory1 implements FactoryMethod {
    public Shape create(String type) {
        switch (type) {
            case "Circle":
                return new Circle();
            case "Square":
//                System.out.println("got square...");
                return new Square();
            case "Triangle":
                return new Triangle();
            default:
                throw new BadShapeCreation(type);
        }
    }

    public static void main(String[] args) {
        FactoryTest.test(new ShapeFactory1());
    }
}
