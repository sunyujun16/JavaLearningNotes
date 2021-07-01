package chap34_collectiontopics;

import java.util.*;

class StringAddress {
    private String s;

    StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}

class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<>(
                Collections.nCopies(4,
                        new StringAddress("Hello")));
        System.out.println(list);

        Collections.fill(list,
                new StringAddress("World!"));
        System.out.println(list);
    }
}
