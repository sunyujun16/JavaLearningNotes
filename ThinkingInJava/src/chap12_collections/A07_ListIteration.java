package chap12_collections;

import chap19_typeinfo.pets.*;

import java.util.*;

public class A07_ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.list(8);
        ListIterator<Pet> it = pets.listIterator();

        while (it.hasNext())
            System.out.print(it.next() +
                    ", " + it.nextIndex() +
                    ", " + it.previousIndex() + "; ");
        System.out.println();

        // Backwards:
        while (it.hasPrevious())
            System.out.print(it.previous().id() + " ");
        System.out.println();
        System.out.println(pets);

        Pets pc = new Pets();
        it = pets.listIterator(3);
        while (it.hasNext()) {
            it.next();
            it.set(pc.get()); // 这里如果不用固定的对象来调用, 而是原位new的话, 那么每次get到的对象都一样
            // 这是因为get的实现中, Random对象的seed是常数47L.
        }
        System.out.println(pets);
    }
}


