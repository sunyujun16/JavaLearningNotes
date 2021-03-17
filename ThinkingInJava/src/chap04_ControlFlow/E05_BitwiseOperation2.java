package chap04_ControlFlow;

public class E05_BitwiseOperation2 {
    private static String myToBinary(int i) {
        String sum = "";
        int k = 0x01;
        for (int j = 0; j < 32; j++) {
            String res = ((i & k) == 0) ? "0" : "1";
            k <<= 1;
            res += sum;
            sum = res;
        }
        return sum;
    }

    private static void binar() {
        int i1 = 0x555;
        int i2 = 0xaaa;

        System.out.println(" " + Integer.toBinaryString(i1));
        System.out.println(Integer.toBinaryString(i2));

        System.out.println("\n& : " + (i1 & i2) + "\n" + myToBinary(i1 & i2));
        System.out.println("\n| : " + (i1 | i2) + "\n" + myToBinary(i1 | i2));
        System.out.println("\n^ : " + (i1 ^ i2) + "\n" + myToBinary(i1 ^ i2));
        System.out.println("\n~ : " + (~i1) + "\n" + myToBinary(~i1));
        System.out.println("\n>>: " + (i2 >> 1) + "\n" + myToBinary(i2 >> 1));
        System.out.println("\n<<: " + (i1 << 1) + "\n" + myToBinary(i1 << 1));
        System.out.println("\n>>>: " + (i2 >>> 1) + "\n" + myToBinary(i2 >>> 1));
    }

    public static void main(String[] args) {
        binar();
    }
}
