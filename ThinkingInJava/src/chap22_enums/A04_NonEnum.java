package chap22_enums;

class NonEnum {
    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        try {
            for (Object en : intClass.getEnumConstants())
                System.out.println(en);
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
    }
}

public class A04_NonEnum {
}
