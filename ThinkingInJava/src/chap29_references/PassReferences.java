package chap29_references;

public class PassReferences {
    public static void f(PassReferences h) {
        System.out.println("h inside f(): " + h);
    }

    public static void main(String[] args) {
        PassReferences p = new PassReferences();
        System.out.println("p inside main(): " + p);
        f(p);
    }
}
/* Output:
p inside main(): PassReferences@15db9742
h inside f(): PassReferences@15db9742
*/