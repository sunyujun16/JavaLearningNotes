package chap15_exceptions;

// Guaranteeing proper cleanup of a resource
public class A10_Cleanup {
    public static void main(String[] args) {
        try {
            A10_InputFile in = new A10_InputFile(
                    "ThinkingInJava/src/chap15_exceptions/A10_Cleanup.java");
            try {
                String s;
                int i = 1;
                while ((s = in.getLine()) != null)
                    ; // Perform line-by-line processing here...
            } catch (Exception e) {
                System.out.println("Caught Exception in main");
                e.printStackTrace(System.out);
            } finally {
                in.dispose();
            }
        } catch (Exception e) {
            System.out.println(
                    "InputFile construction failed");
        }
    }
}


