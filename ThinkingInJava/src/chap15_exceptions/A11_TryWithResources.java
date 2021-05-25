package chap15_exceptions;

import java.io.*;

public class A11_TryWithResources {
    public static void main(String[] args) {
        try (
                InputStream in = new FileInputStream(
                        new File("TryWithResources.java"))
        ) {
            int contents = in.read();
            // Process contents
        } catch (IOException e) {
            // Handle the error
        }
    }
}


