package chap18_strings;

public class A06_IntegerMatch {
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));

        System.out.println("5678".matches("-?\\d+"));

        System.out.println("+911".matches("-?\\d+"));  // 从头开始匹配

        System.out.println("+911".matches("(-|\\+)?\\d+"));
    }
}
