package chap20_generics;

import java.util.*;
import java.util.function.*;

import onjava.*;

class IntegerFactory implements Supplier<Integer> {
    private int i = 0;

    @Override
    public Integer get() {
        return ++i;
    }
}

class Widget {
    private int id;

    Widget(int n) {
        id = n;
    }

    @Override
    public String toString() {
        return "Widget " + id;
    }

    public static class Factory implements Supplier<Widget> {
        private int i = 0;

        @Override
        public Widget get() {
            return new Widget(++i);
        }
    }
}

class Fudge {
    private static int count = 1;
    private int n = count++;

    @Override
    public String toString() {
        return "Fudge " + n;
    }
}

class Foo2<T> {
    private List<T> x = new ArrayList<>();

    Foo2(Supplier<T> factory) {
        Suppliers.fill(x, factory, 5);
    }

    @Override
    public String toString() {
        return x.toString();
    }
}

class FactoryConstraint {
    public static void main(String[] args) {
        System.out.println(
                new Foo2<Integer>(new IntegerFactory()));

        System.out.println(
                new Foo2<>(new Widget.Factory())); // diamond syntax

        System.out.println(
                new Foo2<Fudge>(Fudge::new));
    }
}

public class A06_FactoryConstraint {
}
