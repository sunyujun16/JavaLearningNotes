package chap29_references;

// Method calls implicitly alias their arguments
public class A01_Alias2 {
    private int i;

    public A01_Alias2(int i) {
        this.i = i;
    }

    public static void f(A01_Alias2 reference) {
        reference.i++;
    }

    public static void main(String[] args) {
        A01_Alias2 x = new A01_Alias2(7);
        System.out.println("x: " + x.i);
        System.out.println("Calling f(x)");

        f(x);
        System.out.println("x: " + x.i);
    }
}
