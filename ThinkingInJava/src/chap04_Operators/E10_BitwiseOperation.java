package chap04_Operators;

public class E10_BitwiseOperation {
    public static void main(String[] args) {
        int i1 = 0x555;
        int i2 = 0xaaa;

//        System.out.println(" " + Integer.toBinaryString(i1));
//        System.out.println(Integer.toBinaryString(i2));
//
//        System.out.println("\n& : " + (i1 & i2) + "\n" + Integer.toBinaryString((i1 & i2)));
//        System.out.println("\n| : " + (i1 | i2) + "\n" + Integer.toBinaryString((i1 | i2)));
//        System.out.println("\n^ : " + (i1 ^ i2) + "\n" + Integer.toBinaryString((i1 ^ i2)));
//        System.out.println("\n~ : " + (~i1) + "\n" + Integer.toBinaryString((~i1)));
//        System.out.println("\n>>: " + (i2 >> 1) + "\n" + Integer.toBinaryString((i2 >> 1)));
//        System.out.println("\n<<: " + (i1 << 1) + "\n" + Integer.toBinaryString((i1 << 1)));
//        System.out.println("\n>>>: " + (i2 >>> 1) + "\n" + Integer.toBinaryString((i2 >>> 1)));

        int i3 = -1;
        System.out.println(Integer.toBinaryString(i3));

        System.out.println("---------------------");
        int i4 = Integer.MAX_VALUE;
        System.out.println(i4);
        System.out.println("0"+Integer.toBinaryString(i4));
        System.out.println("---------------------");

        int i5 = -2147483648;
        System.out.println(Integer.toBinaryString(i5));
        System.out.println("---------------------");

        int i6 = -7;
        i6 >>= 1;
        System.out.println(i6); // 所以负数也是除以2
        i6 <<= 1;
        System.out.println(i6);

    }
}
