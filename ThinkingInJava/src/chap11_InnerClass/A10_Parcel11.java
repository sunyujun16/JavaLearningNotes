package chap11_InnerClass;

// Nested classes (static inner classes)
public class A10_Parcel11 {
    private static class ParcelContents implements A07_Contents {
        private int i = 11;

        public ParcelContents() {
            System.out.println("God is a girl.");
        }

        @Override
        public int value() {
            return i;
        }
    }

    private static final class ParcelDestination implements A07_Destination {
        private String label;

        private ParcelDestination(String whereTo) {
            label = whereTo;
            System.out.println("label initialized: "+ label);
        }

        @Override
        public String readLabel() {
            return label;
        }

        // Nested classes can contain other static elements:
        public static void f() {}

        static int x = 10;

        static class AnotherLevel {
            public static void f() {
            }

            static int x = 10;
        }
    }

    public static A07_Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static A07_Contents contents() {
        return new ParcelContents();
    }

    public static void main(String[] args) {
        A07_Contents c = contents();
        A07_Destination d = destination("God is yourself.");
    }
}

