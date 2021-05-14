package chap12_collections;


import java.util.*;

import reflection.pets.*;

public class A12_InterfaceVsIterator {
    public static void display(Iterator<Pet> it) {

        while (it.hasNext()) {
            reflection.pets.Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }

    public static void display(Collection<Pet> pets) {
        for (Pet p : pets)
            System.out.print(p.id() + ":" + p + " ");
        System.out.println();
    }

    private static List<Pet> genPets(int n){
        PetCreator ptc = new PetCreator();
        return ptc.list(n);
    }

    public static void main(String[] args) {
        List<Pet> petList = genPets(8);
        Set<Pet> petSet = new HashSet<>(petList);
        Map<String, Pet> petMap = new LinkedHashMap<>();
        String[] names = ("Ralph, Eric, Robin, Lacey, " +
                "Britney, Sam, Spot, Fluffy").split(", ");
        for (int i = 0; i < names.length; i++)
            petMap.put(names[i], petList.get(i));

        display(petList);
        display(petSet);
        display(petList.iterator());
        display(petSet.iterator());
        System.out.println("-----------------------");
        System.out.println(petMap);
        System.out.println(petMap.keySet());
        System.out.println("-----------------------");
        display(petMap.values());
        display(petMap.values().iterator());
    }
}

