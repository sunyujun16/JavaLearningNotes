package chap24_concurrent;

class StaticIDField implements HasID {
    private static int counter = 0; // unsafe.static can be used same time
    private int id = counter++;

    @Override
    public int getID() {
        return id;
    }
}

public class A12_StaticIDField {
}
