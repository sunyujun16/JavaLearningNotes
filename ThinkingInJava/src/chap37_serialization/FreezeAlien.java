package chap37_serialization;

// Create a serialized output file

import java.io.*;

public class FreezeAlien {
    public static void main(String[] args) throws Exception {
        try (
                ObjectOutputStream out = new ObjectOutputStream(
                        new FileOutputStream("ThinkingInJava/src/" +
                                "chap37_serialization/X.file"));
        ) {
            Alien quellek = new Alien();
            out.writeObject(quellek);
        } // 注意这里为什么不需要有关闭文件之类的操作.
    }
}
