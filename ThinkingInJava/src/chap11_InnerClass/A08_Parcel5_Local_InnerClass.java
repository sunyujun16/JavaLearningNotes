package chap11_InnerClass;

// Nesting a class within a method
public class A08_Parcel5_Local_InnerClass {

    public A07_Destination destination(String s) {
        final class PDestination implements A07_Destination {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        A08_Parcel5_Local_InnerClass p = new A08_Parcel5_Local_InnerClass();
        A07_Destination d = p.destination("Tasmania");
    }

}

