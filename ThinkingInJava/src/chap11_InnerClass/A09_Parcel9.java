package chap11_InnerClass;

public class A09_Parcel9 {
    // Argument must be final or "effectively final"
// to use within the anonymous inner class:
    public A07_Destination destination(final String dest) {
        return new A07_Destination() {
            private String label = dest;
            @Override
            public String readLabel() { return label; }
        };
    }
    public static void main(String[] args) {
        A09_Parcel9 p = new A09_Parcel9();
        A07_Destination d = p.destination("Tasmania");
        System.out.println(d.readLabel());
    }
}