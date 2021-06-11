package chap18_strings;

public class E06 {
    private int i1 = 1;
    private long l2 = 123L;
    private float f3 = 1.23F;
    private double d4 = 3.21;

    @Override
    public String toString() {
        return String.format("%02d  %04x%6.1f%8.1g", i1, l2, f3, d4);
    }

    public static void main(String[] args) {
        E06 e06 = new E06();
        System.out.println(e06);
    }
}
