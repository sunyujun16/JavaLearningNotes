package chap25_patterns.shapes;

import java.util.*;
import java.lang.reflect.*;
import java.util.stream.*;

public class ShapeFactory2 implements FactoryMethod {
    Map<String, Constructor> factories =
            new HashMap<>();

    static Constructor load(String id) {
        System.out.println("loading " + id);
        try {
            return Class.forName("chap25_patterns.shapes." + id)
                    .getConstructor();
        } catch (ClassNotFoundException |
                NoSuchMethodException e) {
            throw new BadShapeCreation(id);
        }
    }

    public Shape create(String id) {
        try {
            return (Shape) factories
                    .computeIfAbsent(id, ShapeFactory2::load)
                    .newInstance();
        } catch (InstantiationException |
                IllegalAccessException |
                InvocationTargetException e) {
            throw new BadShapeCreation(id);
        }
    }

    public static void main(String[] args) {
        FactoryTest.test(new ShapeFactory2());
    }
}
