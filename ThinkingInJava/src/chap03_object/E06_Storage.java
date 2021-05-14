package chap03_object;

public class E06_Storage {
    private String s = "Hello..."; // 成员变量, 内存在...
    private int n = 0;

    private int storage(String s) {
        return s.length() * 2;
    }

    private void print() {
        String s = "Hello, World!"; // Change to local variable, runs faster in stack.
        int n = 1;
        System.out.println("storage(s) = " + storage(s) + "\nn is : "+n);
    }

    public static void main(String[] args) {
        E06_Storage st = new E06_Storage();
        st.print();
    }
}
