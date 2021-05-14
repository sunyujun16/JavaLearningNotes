package chap11_inner_class;

// Nesting a class within a scope
public class A08_Parcel6 {
    private void internalTracking(boolean b, String ss) {
        if (b) {
            // gets compiled along with everything else
            class TrackingSlip {
                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getSlip() {
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip(ss);
            String s = ts.getSlip();
            System.out.println(s);
        }

// Can't use it here! Out of scope:
//- TrackingSlip ts = new TrackingSlip("x");
    }

    public void track() {
        internalTracking(true, "slip");
    }

    public static void main(String[] args) {
        A08_Parcel6 p = new A08_Parcel6();
        p.track();
    }

}
