package chap04_operators;

public class E14_CompareStrings {
    private static void comp(String a, String b) {
        //noinspection StringEquality
        if (a == b)
            System.out.println("exactly the same.");
        else if (a.equals(b)) {
            System.out.println("equal.");
        } else
            System.out.println("Nothing alike.");
    }

    public static void main(String[] args) {
        comp("fuck", "fuck");
        String s1 = "fuck";
        String s2 = new String("fuck");
//        String s3 = s1;

        System.out.println("12:");
        comp(s1, s2);
        System.out.println("13:");
//        comp(s1, s3);

    }

}
