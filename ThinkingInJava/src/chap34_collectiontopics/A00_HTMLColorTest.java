package chap34_collectiontopics;

import static onjava.HTMLColors.*;
public class A00_HTMLColorTest {
    static final int DISPLAY_SIZE = 20;
    public static void main(String[] args) {
        show(MAP, DISPLAY_SIZE);
        border();
        showInv(INVMAP, DISPLAY_SIZE);
        border();
        show(LIST, DISPLAY_SIZE);
        border();
        showrgb(RGBLIST, DISPLAY_SIZE);
    }
}
