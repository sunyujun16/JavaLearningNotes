package chap17_files;

import java.io.IOException;
import java.nio.file.*;

public class A01_NewDir {
    public static void newDir(Path dirPath){
        try {
            Files.createDirectory(dirPath);
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public static void newFile(Path filePath){
        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
//        newDir(Paths.get("ThinkingInJava/src/generics/coffee"));
        newFile(Paths.get("ThinkingInJava/src/generics/try.txt"));
    }
}
