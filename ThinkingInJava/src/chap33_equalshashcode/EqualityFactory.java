package chap33_equalshashcode;

import java.util.*;

@FunctionalInterface
interface EqualityFactory {
    Equality make(int i, String s, double d);
}
