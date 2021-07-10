package chap06_housekepping;

public class OverloadingVarargs2 {
    static void f(float i, Character... args) {
        System.out.println("first");
    }

    static void f(Character... args) {
        System.out.println("second");
    }

    public static void main(String[] args) {
        f(1, 'a'); // first
//        f('a', 'b'); // error 'a'可以被float接收.
    }
}
