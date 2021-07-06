package chap31_standardio;
// Demonstrates standard I/O redirection
// {javap -cp build/classes/main OSExecuteDemo}

import onjava.*;

public class OSExecuteDemo {
    public static void main(String[] args) {
        OSExecute.command("java -version");
    }
}
