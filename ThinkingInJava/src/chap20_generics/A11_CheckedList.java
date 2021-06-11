package chap20_generics;

// Using Collection.checkedList()

import chap19_typeinfo.pets.*;

import java.util.*;

class CheckedList {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs) {
        // 为什么这样呢,这是因为参数的List是一个rawType,也就是说接收任何Object.
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<>();
        oldStyleMethod(dogs1); // Quietly accepts a Cat, fuck...
        // 这也太蛋疼了...因为运行时的类型丢失.


        List<Dog> dogs2 = Collections.checkedList(
                new ArrayList<>(), Dog.class);
        try {
            oldStyleMethod(dogs2); // Throws an exception
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }

        // Derived types work fine:
        List<Pet> pets = Collections.checkedList(
                new ArrayList<>(), Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());
    }
}

public class A11_CheckedList {
}
