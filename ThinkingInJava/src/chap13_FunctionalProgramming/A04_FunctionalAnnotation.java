package chap13_FunctionalProgramming;

@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

interface FunctionalNoAnn {
    String goodbye(String arg);
}

/*
@FunctionalInterface
interface NotFunctional {
  String goodbye(String arg);
  String hello(String arg);
}
产生错误信息:
NotFunctional is not a functional interface
multiple non-overriding abstract methods
found in interface NotFunctional
*/

public class A04_FunctionalAnnotation {
    public String goodbye(String arg) {
        return "Goodbye, " + arg;
    }
    public static void main(String[] args) {
        A04_FunctionalAnnotation fa =
                new A04_FunctionalAnnotation();
        Functional f = fa::goodbye;
        FunctionalNoAnn fna = fa::goodbye;
        // Functional fac = fa; // Incompatible
        Functional fl = a -> "Good bye, " + a;
        FunctionalNoAnn fnal = a -> "Good bye, " + a;

        System.out.println(f.goodbye("f"));
        System.out.println(fna.goodbye("fna"));
        System.out.println(fl.goodbye("fl"));
        System.out.println(fnal.goodbye("fnal"));
    }
}