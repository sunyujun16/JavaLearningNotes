package chap19_typeinfo.pets;

import java.util.*;
import java.util.function.*;

public abstract class PetCreator implements Supplier<Pet> {
    private Random rand = new Random(47);

    // The List of the different types of Pet to create:
    public abstract List<Class<? extends Pet>> types();

    @Override
    public Pet get() { // Create one random Pet
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (InstantiationException |
                IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
    }
}
