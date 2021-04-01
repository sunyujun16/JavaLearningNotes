package chap11_Collections;

// {VisuallyInspectOutput}

import java.util.*;

public class A13_EnvironmentVariables {
    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

