package chap37_serialization;

import java.io.*;
import java.util.*;

class House implements Serializable {
}

class Animal implements Serializable {
    private String name;
    private House preferredHouse;

    Animal(String nm, House h) {
        name = nm;
        preferredHouse = h;
    }

    @Override
    public String toString() {
        return name + "[" + super.toString() + // for address.
                "], " + preferredHouse + "\n";
    }
}

public class MyWorld {
    public static void main(String[] args) {
        House house = new House();
        List<Animal> animals = new ArrayList<>();
        // 3 animals same house. Cat would probably eat the hamster.
        animals.add(
                new Animal("dog", house));
        animals.add(
                new Animal("hamster", house));
        animals.add(
                new Animal("cat", house));
        System.out.println("animals: \n" + animals);
        try (
                ByteArrayOutputStream buf1 =
                        new ByteArrayOutputStream();
                ObjectOutputStream o1 =
                        new ObjectOutputStream(buf1)
        ) {
            o1.writeObject(animals);
            o1.writeObject(animals); // Write a 2nd set

            // Write to a different stream:
            try (
                    ByteArrayOutputStream buf2 =
                            new ByteArrayOutputStream();
                    ObjectOutputStream o2 =
                            new ObjectOutputStream(buf2)
            ) {
                o2.writeObject(animals);

                // Now get them back:
                try (
                        ObjectInputStream in1 =
                                new ObjectInputStream(
                                        new ByteArrayInputStream(
                                                buf1.toByteArray()));
                        ObjectInputStream in2 =
                                new ObjectInputStream(
                                        new ByteArrayInputStream(
                                                buf2.toByteArray()))
                ) {
                    List
                            animals1 = (List) in1.readObject(),
                            animals2 = (List) in1.readObject(),
                            animals3 = (List) in2.readObject();
                    System.out.println(
                            "animals1: \n" + animals1);
                    System.out.println(
                            "animals2: \n" + animals2);
                    System.out.println(
                            "animals3: \n" + animals3);
                    // 不同步的写入返回了不同的对象.
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
