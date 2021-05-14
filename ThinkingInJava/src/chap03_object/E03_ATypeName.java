package chap03_object;

public class E03_ATypeName {
    @Override
    public String toString() {
        return "E03_ATypeName{}";
    }

    public static void main(String[] args) {
        System.out.println("Ah hah.");
        E03_ATypeName e = new E03_ATypeName();
        System.out.println(e);
    }
}
