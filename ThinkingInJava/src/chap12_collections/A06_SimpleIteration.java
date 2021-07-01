package chap12_collections;

import chap19_typeinfo.pets.*;

import java.util.*;

public class A06_SimpleIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.list(12);
        Iterator<Pet> it = pets.iterator();
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();

        // A simpler approach, when possible:
        for (Pet p : pets)
            System.out.print(p.id() + ":" + p + " ");
        System.out.println();

        // An Iterator can also remove elements:
        it = pets.iterator();
        for (int i = 0; i < 6; i++) {
            it.next();
            it.remove(); // remove动作比较危险, 我猜底层使用了原列表的副本.
        }
        System.out.println(pets);
    }
}


