package chap18_strings;

public class A06_Replacing {
    static String s = A06_Splitting.knights;

    public static void main(String[] args) {
        System.out.println(
                s.replaceFirst("f\\w+", "located"));
        System.out.println(
                s.replaceAll("shrubbery|tree|herring", "banana"));
    }
}
