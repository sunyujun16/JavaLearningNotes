package chap04_Operators;

public class E10_BitwiseOperation {
    public static void main(String[] args) {
        int i1 = 0x555;
        int i2 = 0xaaa;

        System.out.println(" " + Integer.toBinaryString(i1));
        System.out.println(Integer.toBinaryString(i2));

        System.out.println("\n& : " + (i1 & i2) + "\n" + Integer.toBinaryString((i1 & i2)));
        System.out.println("\n| : " + (i1 | i2) + "\n" + Integer.toBinaryString((i1 | i2)));
        System.out.println("\n^ : " + (i1 ^ i2) + "\n" + Integer.toBinaryString((i1 ^ i2)));
        System.out.println("\n~ : " + (~i1) + "\n" + Integer.toBinaryString((~i1)));
        System.out.println("\n>>: " + (i2 >> 1) + "\n" + Integer.toBinaryString((i2 >> 1)));
        System.out.println("\n<<: " + (i1 << 1) + "\n" + Integer.toBinaryString((i1 << 1)));
        System.out.println("\n>>>: " + (i2 >>> 1) + "\n" + Integer.toBinaryString((i2 >>> 1)));
    }
}
