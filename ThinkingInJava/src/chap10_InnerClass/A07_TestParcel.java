package chap10_InnerClass;

class Parcel4 {
    private class PContents implements A07_Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected final class PDestination implements A07_Destination {
        private String label;

        private PDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }

        String getLabel(){
            return label;
        }
    }

    // E08
    void getP(){
//        label = ""; // Nah...
        PDestination p = new PDestination("haha");
        String s = p.getLabel();
        System.out.println(s);
    }

    public A07_Destination destination(String s) {
        return new PDestination(s);
    }

    public A07_Contents contents() {
        return new PContents();
    }
}

public class A07_TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        A07_Contents c = p.contents();
        A07_Destination d = p.destination("Tasmania");

        p.getP();

        // Illegal -- can't access private class:
        //- Parcel4.PContents pc = p.new PContents();
    }
}
