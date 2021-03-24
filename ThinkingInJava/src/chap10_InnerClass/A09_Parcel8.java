package chap10_InnerClass;

// Calling the base-class constructor
public class A09_Parcel8 {
    public Wrapping wrapping(int x) {
// Base constructor call:
        return new Wrapping(x) { // [1]
            @Override
            public int value() {
                return super.value() * 47;
            }
        }; // [2]
    }
    public static void main(String[] args) {
        A09_Parcel8 p = new A09_Parcel8();
        Wrapping w = p.wrapping(10);
        System.out.println(w.value());
    }
}

// In book, this was in a distinguish .java file
class Wrapping {
    private int i;
    public Wrapping(int x) { i = x; }
    public int value() { return i; }
}