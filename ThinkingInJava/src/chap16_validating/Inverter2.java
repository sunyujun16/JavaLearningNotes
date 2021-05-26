package chap16_validating;

import static java.lang.Character.*;

public class Inverter2 implements StringInverter {
    public String invert(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result += isUpperCase(c) ?
                    toLowerCase(c) :
                    toUpperCase(c);
            // 虽然短小, 但是多么优雅...
        }
        return result;
    }
}
