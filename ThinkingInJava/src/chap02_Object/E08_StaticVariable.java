package chap02_Object;

public class E08_StaticVariable {
    private static int n = 0;

    public static void main(String[] args) {
//        E08_StaticVariable sv1 = new E08_StaticVariable();
//        E08_StaticVariable sv2 = new E08_StaticVariable();
//        sv1.n ++;
//        System.out.println("sv1: "+ sv1.n+"\nsv2: "+sv2.n);
        System.out.println(E08_StaticVariable.n);
        System.out.println("Code annotated. Please edit before running it.");
    }
}
