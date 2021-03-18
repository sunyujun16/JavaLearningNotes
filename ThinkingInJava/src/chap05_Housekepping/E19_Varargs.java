package chap05_Housekepping;

public class E19_Varargs {
    private static void printString(String... args){
        for (String arg:args) {
            System.out.println(arg);
        }
    }

    public static void main(String[] args) {
        printString("sunyujun", "likes", "liuyihan");
        E20_Varargs2.main("haha", 2, 'c', true, 3.14f, new StringBuilder("asdf"));
    }

}

// E20
class E20_Varargs2{
    public static void main(Object... args) {
        for (Object arg:args) {
            System.out.println(arg);
        }
    }
}
