package chap11_inner_class;

// Using .new to create instances of inner classes
public class A06_Parcel3 {
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    public static void main(String[] args) {
        A06_Parcel3 p = new A06_Parcel3();

        // Must use instance of outer class
        // to create an instance of the inner class:
        A06_Parcel3.Contents c = p.new Contents();
        A06_Parcel3.Destination d =
                p.new Destination("Tasmania");
        System.out.println(d.readLabel());
    }
}

