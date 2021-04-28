package chap12_Collections;

import reflection.pets.*;

import java.util.*;

class PetSequence {
    protected Pet[] pets = new PetCreator().array(8);
}

/** @noinspection Duplicates*/
public class A12_NonCollectionSequence extends PetSequence {
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
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
        A12_NonCollectionSequence nc =
                new A12_NonCollectionSequence();
        A12_InterfaceVsIterator.display(nc.iterator());
    }
}


