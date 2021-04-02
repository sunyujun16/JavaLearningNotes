package chap11_Collections;

import java.util.*;

public class E17_GerbilsMap {
    public enum Names{
        ONE, TWO, THREE, FOUR,
    }

    public static void main(String[] args) {
        ArrayList<E01_Gerbil> gerbils = new ArrayList<>();

        System.out.println(Names.valueOf("ONE"));

        HashMap<String, E01_Gerbil> gers = new HashMap<>();
        gers.put("one", new E01_Gerbil(1));
        gers.put("two", new E01_Gerbil(2));
        gers.put("three", new E01_Gerbil(3));

        for (String name: gers.keySet()) {
            System.out.println(gers.get(name).hop() + "\n");
        }

    }

}
