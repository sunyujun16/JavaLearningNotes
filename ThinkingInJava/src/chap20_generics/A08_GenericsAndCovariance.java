package chap20_generics;

import java.util.*;

class GenericsAndCovariance {
    public static void main(String[] args) {
        // Wildcards allow covariance:
        List<? extends Fruit> flist = new ArrayList<>();

        // Compile Error: can't add any type of object:
        // flist.add(new Apple());
//         flist.add(new Fruit());
        // flist.add(new Object());

        flist.add(null); // Legal but uninteresting

        // We know it returns at least Fruit:
        Fruit f = flist.get(0);
    }
}

public class A08_GenericsAndCovariance {
}
