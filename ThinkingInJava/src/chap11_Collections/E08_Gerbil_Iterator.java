package chap11_Collections;

import java.util.*;

public class E08_Gerbil_Iterator {
    /** @noinspection Duplicates*/
    public static void main(String[] args) {
        ArrayList<E01_Gerbil> gerbils = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            gerbils.add(new E01_Gerbil(i));
        }

        System.out.println(gerbils.get(0));
        System.out.println("----------------");

//        for (E01_Gerbil gerbil:gerbils) {
//            System.out.println(gerbil);
//            gerbil.hop();
//            System.out.println("----------------");
//        }

        // 很简洁的写法, 记住咯.
        //noinspection StatementWithEmptyBody
        for (Iterator<E01_Gerbil> it = gerbils.iterator();
             it.hasNext();
             it.next().hop());
    }
}



