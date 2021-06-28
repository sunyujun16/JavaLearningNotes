package chap29_references;

public class A01_PassReferences {
    public static void f(A01_PassReferences h) {
        System.out.println("h inside f(): " + h);
    }

    public static void main(String[] args) {
        A01_PassReferences p = new A01_PassReferences();
        System.out.println("p inside main(): " + p);
        f(p);
    }
}
/* Output:
p inside main(): A01_PassReferences@15db9742
h inside f(): A01_PassReferences@15db9742
*/