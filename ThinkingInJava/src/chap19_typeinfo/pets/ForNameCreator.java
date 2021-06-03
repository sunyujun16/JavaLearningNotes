// reflection/pets/ForNamePetCreator.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package chap19_typeinfo.pets;

import java.util.*;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types =
            new ArrayList<>();

    // Types you want randomly created:
    private static String[] typeNames = {
            "chap19_typeinfo.pets.Mutt",
            "chap19_typeinfo.pets.Pug",
            "chap19_typeinfo.pets.EgyptianMau",
            "chap19_typeinfo.pets.Manx",
            "chap19_typeinfo.pets.Cymric",
            "chap19_typeinfo.pets.Rat",
            "chap19_typeinfo.pets.Mouse",
            "chap19_typeinfo.pets.Hamster"
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames)
                types.add(
                        (Class<? extends Pet>) Class.forName(name));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}