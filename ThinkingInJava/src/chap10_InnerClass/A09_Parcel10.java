package chap10_InnerClass;

// Using "instance initialization" to perform
// construction on an anonymous inner class
public class A09_Parcel10 {
    public A07_Destination destination(final String dest, final float price) {
        return new A07_Destination() {
            private int cost;

            // Instance initialization for each object:
            {
                cost = Math.round(price);
                if (cost > 100)
                    System.out.println("Over budget!");
            }

            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        A09_Parcel10 p = new A09_Parcel10();
        A07_Destination d = p.destination("Tasmania", 101.395F);
    }
}
