package chap19_typeinfo.pets;

import java.util.*;

public class Pets {
    public static List<Pet> array(int num) {
        ForNameCreator fmc = new ForNameCreator();
        ArrayList<Pet> mytypes = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            mytypes.add(fmc.get());
        }
        System.out.println(mytypes);

        return mytypes;
    }

    public static void main(String[] args) {
        array(20);
    }
}
