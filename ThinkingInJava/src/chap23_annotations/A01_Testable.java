package chap23_annotations;

import onjava.atunit.*;

class Testable {
    public void execute() {
        System.out.println("Executing..");
    }

    @Test
    void testExecute() {
        execute();
    }
}

public class A01_Testable {
}
