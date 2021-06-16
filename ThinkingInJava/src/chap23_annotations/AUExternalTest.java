package chap23_annotations;

import onjava.atunit.*;
import onjava.*;

public class AUExternalTest extends AtUnitExample1 {
    @Test
    boolean _MethodOne() {
        return methodOne().equals("This is methodOne");
    }

    @Test
    boolean _MethodTwo() {
        return methodTwo() == 2;
    }
}
