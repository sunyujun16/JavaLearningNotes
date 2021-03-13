package chap02_Object;

public class E09_Autoboxing {
    /** @noinspection UnnecessaryLocalVariable, WrapperTypeMayBePrimitive */
    public static void main(String[] args) {
        Byte by = 1;
        byte bt = by;
        System.out.println("byte = " + bt);
        Short sh = 1;
        short s = sh;
        System.out.println("short = " + s);
        Integer in = 1;
        int i = in;
        System.out.println("int = " + i);
        Long lo = 1L;  // L 必须要有, 建议大写
        long l = lo;
        System.out.println("long = " + l);
        Boolean bo = true;
        boolean b = bo;
        System.out.println("boolean = " + b);
        Character ch = 'x';
        char c = ch;
        System.out.println("char = " + c);
        Float fl = 1.0f;  // f 必须要有
        float f = fl;
        System.out.println("float = " + f);
        Double db = 1.0d; // d 有没有都行
        double d = db;
        System.out.println("double = " + d);
    }
}
