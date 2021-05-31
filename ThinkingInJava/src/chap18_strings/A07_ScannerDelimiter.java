package chap18_strings;

import java.util.*;

public class A07_ScannerDelimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("12, 42  , 78, 99, 42");
        scanner.useDelimiter("\\s*,\\s*");
        System.out.println(scanner.delimiter());
        while (scanner.hasNextInt())
            System.out.println(scanner.nextInt());

    }
}
