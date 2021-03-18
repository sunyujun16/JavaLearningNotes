package chap05_Housekepping;

public class E18_InitializeArray {
    private E18_InitializeArray(String name) {
        System.out.println("Haha, I'm back. --" + name);
    }

    public static void main(String[] args) {
        E18_InitializeArray[] ar1 = new E18_InitializeArray[3];
        // Nothing happened.

        // Initialize references
        for (int i = 0; i < 3; i++) {
            ar1[i] = new E18_InitializeArray("SunYujun"+i);
        }

    }

}
