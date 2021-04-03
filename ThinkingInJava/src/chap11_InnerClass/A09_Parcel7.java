package chap11_InnerClass;

// Returning an instance of an anonymous inner class
public class A09_Parcel7 {
    public A07_Contents contents() {
        return new A07_Contents() { // Insert class definition. !!A07_Contents is an interface.
            // And it does not mean the class name , this class does not have any name.(anonymous)
            private int i = 11;

            @Override
            public int value() {
                return i;
            }
        }; // Semicolon required
    }

    public static void main(String[] args) {
        A09_Parcel7 p = new A09_Parcel7();
        A07_Contents c = p.contents();
        System.out.println("i: " + c.value());
    }
}

