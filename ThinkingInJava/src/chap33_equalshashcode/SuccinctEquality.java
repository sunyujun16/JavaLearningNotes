package chap33_equalshashcode;

import java.util.*;

public class SuccinctEquality extends Equality {
    public SuccinctEquality(int i, String s, double d) {
        super(i, s, d);
        System.out.println("made 'SuccinctEquality'");
    }

    @Override
    public boolean equals(Object rval) {
        return rval instanceof SuccinctEquality &&
                Objects.equals(i, ((SuccinctEquality) rval).i) &&
                Objects.equals(s, ((SuccinctEquality) rval).s) &&
                Objects.equals(d, ((SuccinctEquality) rval).d);
    }

    public static void main(String[] args) {
        Equality.testAll((i, s, d) ->
                new SuccinctEquality(i, s, d));
    }
}
