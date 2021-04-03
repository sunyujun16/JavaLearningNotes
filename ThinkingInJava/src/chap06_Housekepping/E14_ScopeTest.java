package chap06_Housekepping;

public class E14_ScopeTest {
    static String s1 = "1-1";
    static String s2;

    static {
        s2 = "2-2";
    }

    public static void main(String[] args) {
        System.out.println("s1: " + s1 + "\ns2: " + s2);
    }
}
