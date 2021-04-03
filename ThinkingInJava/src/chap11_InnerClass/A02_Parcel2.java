package chap11_InnerClass;

// Returning a reference to an inner class
public class A02_Parcel2 {
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

    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        A02_Parcel2 p = new A02_Parcel2();
        p.ship("Tasmania");
        A02_Parcel2 q = new A02_Parcel2();
// Defining references to inner classes:
        A02_Parcel2.Contents c = q.contents();
        A02_Parcel2.Destination d = q.to("Borneo");
    }
}

