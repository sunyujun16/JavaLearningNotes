package chap03_object;

public class E01_Initialize {
    private int n;
    private char ch;
    private String s;

    public E01_Initialize() {
    }

    @Override
    public String toString() {
        return "E01_Initialize{打印未初始化的值}";
    }

    public void showValue() {
        System.out.println(Integer.toString(n));
        System.out.println(ch+"");
        System.out.println(s);
    }

    public static void main(String[] arg) {
        E01_Initialize e = new E01_Initialize();
        System.out.println(e);
        e.showValue();
    }

}
