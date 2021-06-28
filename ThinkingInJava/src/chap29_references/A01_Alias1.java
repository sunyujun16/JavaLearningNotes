package chap29_references;

// Aliasing two references to one object
public class A01_Alias1 {
    private int i;

    public A01_Alias1(int ii) {
        i = ii;
    }

    public static void main(String[] args) {
        A01_Alias1 x = new A01_Alias1(7);
        A01_Alias1 y = x; // Assign the reference (1)

        System.out.println("x: " + x.i);
        System.out.println("y: " + y.i);
        System.out.println("Incrementing x");

        x.i++; // [2]
        System.out.println("x: " + x.i);
        System.out.println("y: " + y.i);
    }
}