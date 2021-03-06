package chap12_collections;

import chap19_typeinfo.pets.*;
import java.util.*;

public class A10_PetMap {
    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<>();

        petMap.put("My Cat", new Cat("Molly"));
        petMap.put("My Dog", new Dog("Ginger"));
        petMap.put("My Hamster", new Hamster("Bosco"));
        System.out.println(petMap);

        Pet dog = petMap.get("My Dog");
        System.out.println(dog);
        System.out.println(petMap.containsKey("My Dog"));
        System.out.println(petMap.containsValue(dog));
    }
}

class PetMap {
}
