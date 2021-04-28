package chap12_Collections;

import reflection.pets.*;

import java.util.*;

public class A12_CollectionSequence extends AbstractCollection<Pet> {
    private Pet[] pets = new PetCreator().array(8);

    @Override
    public int size() {
        return pets.length;
    }

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() { // [1]
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            @Override
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        A12_CollectionSequence c = new A12_CollectionSequence();
        A12_InterfaceVsIterator.display(c);
        A12_InterfaceVsIterator.display(c.iterator());
    }
}


