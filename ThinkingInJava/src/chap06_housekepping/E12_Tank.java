package chap06_housekepping;

// finalize在Java9中彻底废除, 我的版本已然是java15, 此处无法生效.
public class E12_Tank {
    private String status = "Empty";
    private boolean emp = true;

    private void reload(){
        status = "Full";
        emp = false;
    }

    private void fire(){
        status = "Empty";
        emp = true;
    }

    /** @noinspection deprecation*/
    @Override
    public void finalize(){
        if (!emp) System.out.println("Fuck it, get back.");
    }

    public static void main(String[] args) {
        E12_Tank t1 = new E12_Tank();
        E12_Tank t2 = new E12_Tank();

        t1.reload();t2.reload();
        t1.fire(); // t2.fire();

        System.gc();

    }


}
