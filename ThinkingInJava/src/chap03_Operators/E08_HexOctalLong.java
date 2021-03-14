package chap03_Operators;

public class E08_HexOctalLong {
    public static void main(String[] args) {
        long l1 = 0x1a2f;  // hexadecimal
        long l2 = 015060;  // octal

        System.out.println(l1);
        System.out.println(Long.toBinaryString(l1));
        System.out.println(l2);
        System.out.println(Long.toBinaryString(l2));
    }
}
