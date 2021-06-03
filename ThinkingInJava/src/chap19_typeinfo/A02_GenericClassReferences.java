package chap19_typeinfo;

public class A02_GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;

        // 通过使用泛型语法，我们可以让编译器强制执行额外的类型检查。
        Class<Integer> genericIntClass = int.class;

        genericIntClass = Integer.class; // Same thing

        intClass = double.class;

        // genericIntClass = double.class; // Illegal
    }
}
