package chap25_patterns.doubledispatch;
// An interface for adding the double dispatching
// method to the trash hierarchy without
// modifying the original hierarchy

import java.util.*;

public interface TypedBinMember {
    // The new method:
    boolean addToBin(List<TypedBin> bins);
}