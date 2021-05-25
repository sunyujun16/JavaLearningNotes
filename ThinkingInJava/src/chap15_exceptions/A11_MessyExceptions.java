package chap15_exceptions;

import java.io.*;

public class A11_MessyExceptions {
    public static void main(String[] args) {
        InputStream in = null;
        try {
            in = new FileInputStream(
                    new File("ThinkingInJava/src/" +
                            "chap15_exceptions/A10_MessyExceptions.java"));
            int contents = in.read();
            // Process contents
        } catch (IOException e) {
            // Handle the error
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // Handle the close() error
                }
            }
        }
    }
}
