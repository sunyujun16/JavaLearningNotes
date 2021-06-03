package chap19_typeinfo;

import java.util.*;

class Initable {
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL2 =
            A02_ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}

public class A02_ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception {
        Class initable = Initable.class;  // nothing happens.
        System.out.println(initable.getSimpleName()); // still..
        System.out.println("After creating Initable ref");

// Does not trigger initialization:
        System.out.println(Initable.STATIC_FINAL + " nah..");

// Does trigger initialization:
        System.out.println(Initable.STATIC_FINAL2 + " yeah!");

// Does trigger initialization:
        System.out.println(Initable2.staticNonFinal + " yeah!");
        Class initable3 = Class.forName("Initable3"); //init

        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal + " yeah!");
    }
}