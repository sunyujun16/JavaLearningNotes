package chap18_strings;

public class A01_Immutable {
    public static String upcase(String s) {
        return s.toUpperCase();
    }
    public static void main(String[] args) {
        String q = "howdy";
        System.out.println(q); // howdy
        String qq = upcase(q);
        System.out.println(qq); // HOWDY
        System.out.println(q); // howdy

        q.toUpperCase();
        System.out.println(q); // nothing happened.
    }
}

