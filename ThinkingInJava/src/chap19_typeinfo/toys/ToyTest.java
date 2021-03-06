package chap19_typeinfo.toys;

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

interface Fuck {
}

class Toy {
    private int i = 0;
    // Comment out the following no-arg
    // constructor to see NoSuchMethodError
    Toy() {
    }

    Toy(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "* " + i;
    }
}

class FancyToy extends Toy
        implements HasBatteries, Waterproof, Shoots, Fuck {
    FancyToy() {
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        System.out.println(
                "Simple name: " + cc.getSimpleName());
        System.out.println(
                "Canonical name : " + cc.getCanonicalName());
        System.out.println("-------------");
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("chap19_typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);

        for (Class face : c.getInterfaces())
            printInfo(face);

        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // Requires no-arg constructor:
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());


        // 练习19
        System.out.println("");
        Class c2 = Toy.class;
        try {
            System.out.println(
                    c2.getDeclaredConstructor(int.class)
                            .newInstance(2)
            );
//            System.out.println(c2.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
