package chap33_equalshashcode;

import chap12_collections.A10_MapOfList;
import chap19_typeinfo.pets.*;

import java.util.*;

public class IndividualTest {
    public static void main(String[] args) {
        Set pets = new TreeSet<>();
        for (List<Pet> lp :
                A10_MapOfList.petPeople.values())
            for (Pet p : lp)
                pets.add(p);
        pets.forEach(System.out::println);
    }
}
