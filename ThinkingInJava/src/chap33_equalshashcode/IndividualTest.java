package chap33_equalshashcode;

import chap12_collections.A10_MapOfList;
import chap19_typeinfo.pets.*;

import java.util.*;

public class IndividualTest {
    public static void main(String[] args) {
        Set<Pet> pets = new TreeSet<>();
        for (List lp : // List<Pet>被编译器报错, 我知道是擦除, 可书上代码为啥不用呢?
                A10_MapOfList.petPeople.values())
            for (Pet p : (List<Pet>) lp) // 逼我用强制转换...
                pets.add(p);
        pets.forEach(System.out::println);
    }
}
