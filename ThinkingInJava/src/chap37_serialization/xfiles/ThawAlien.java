package chap37_serialization.xfiles;

// Recover a serialized file
// {java serialization.xfiles.ThawAlien}
// {RunFirst: FreezeAlien}

import java.io.*;

public class ThawAlien {
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(new File("ThinkingInJava/src/" +
                        "chap37_serialization/X.file")));
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
}
