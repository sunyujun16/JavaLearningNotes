package chap25_patterns.observer;

import java.util.*;

class Flower {
    private boolean isOpen;
    private boolean alreadyOpen;
    private boolean alreadyClosed;

    Flower() {
        isOpen = false;
    }

    OpenNotifier opening = new OpenNotifier();
    CloseNotifier closing = new CloseNotifier();

    public void open() { // Opens its petals
        isOpen = true;
        opening.notifyObservers();
        alreadyClosed = false;
    }

    public void close() { // Closes its petals
        isOpen = false;
        closing.notifyObservers();
        alreadyOpen = false;
    }

    class OpenNotifier extends Observable {
        @Override
        public void notifyObservers() {
            if (isOpen && !alreadyOpen) {
                setChanged();
                super.notifyObservers(); // 如果这里使用并发, 想必要join一下?
                alreadyOpen = true;
            }
        }
    }

    class CloseNotifier extends Observable {
        @Override
        public void notifyObservers() {
            if (!isOpen && !alreadyClosed) {
                setChanged();
                super.notifyObservers();
                alreadyClosed = true;
            }
        }
    }
}

class Bee {
    private String name;

    Bee(String nm) {
        name = nm;
    }

    // Observe openings:
    public Observer openObserver() {
        // 覆写的是update()方法.
        return (ob, a) -> System.out.println(
                "Bee " + name + "'s breakfast time!");
    }

    // Observe closings:
    public Observer closeObserver() {
        return (ob, a) -> System.out.println(
                "Bee " + name + "'s bed time!");
    }
}

class Hummingbird {
    private String name;

    Hummingbird(String nm) {
        name = nm;
    }

    public Observer openObserver() {
        return (ob, a) -> System.out.println(
                "Hummingbird " + name +
                        "'s breakfast time!");
    }

    public Observer closeObserver() {
        return (ob, a) -> System.out.println(
                "Hummingbird " + name + "'s bed time!");
    }
}

public class ObservedFlower {
    public static void main(String[] args) {
        Flower f = new Flower();
        Bee
                ba = new Bee("A"),
                bb = new Bee("B");
        Hummingbird
                ha = new Hummingbird("A"),
                hb = new Hummingbird("B");

        // 通过addObserver, 建立了观察和被观察者的联系. 他们是一一对应的.
        f.opening.addObserver(ha.openObserver());
        f.opening.addObserver(hb.openObserver());
        f.opening.addObserver(ba.openObserver());
        f.opening.addObserver(bb.openObserver());

        f.closing.addObserver(ha.closeObserver());
        f.closing.addObserver(hb.closeObserver());
        f.closing.addObserver(ba.closeObserver());
        f.closing.addObserver(bb.closeObserver());

        // Hummingbird B decides to sleep in:
        f.opening.deleteObserver(hb.openObserver()); // 没用

        System.out.println("---------------------1");
        // A change that interests observers:
        f.open();
        f.open(); // It's already open, no change.

        System.out.println("---------------------2");
        // Bee A doesn't want to go to bed:
        f.closing.deleteObserver(ba.closeObserver()); // 没用
        f.close();
        f.close(); // It's already closed; no change

        System.out.println("---------------------3");
        f.opening.deleteObservers();
        f.open(); // deleted.
        f.close();
    }
}
