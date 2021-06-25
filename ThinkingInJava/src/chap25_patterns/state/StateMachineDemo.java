package chap25_patterns.state;

// The StateMachine pattern and Template method
// {java patterns.state.StateMachineDemo}

import onjava.Nap;

interface State {
    void run();
}

abstract class StateMachine {
    protected State currentState;

    protected abstract boolean changeState();

    // Template method:
    protected final void runAll() {
        while (changeState()) // Customizable,这个思维模式值得寻味,真的是有高度.
            currentState.run();
    }
}

// A different subclass for each state:
class Wash implements State {
    @Override
    public void run() {
        System.out.println("Washing");
        new Nap(0.5);
    }
}

class Spin implements State {
    @Override
    public void run() {
        System.out.println("Spinning");
        new Nap(0.5);
    }
}

class Rinse implements State {
    @Override
    public void run() {
        System.out.println("Rinsing");
        new Nap(0.5);
    }
}

class Washer extends StateMachine {
    private int i = 0;
    // The state table:
    private State[] states = {
            new Wash(), new Spin(),
            new Rinse(), new Spin(),
    };

    Washer() {
        runAll();
    }

    @Override
    public boolean changeState() {
        if (i < states.length) {
            // Change the state by setting the
            // surrogate reference to a new object:
            currentState = states[i++];
            return true;
        } else
            return false;
    }
}

public class StateMachineDemo {
    public static void main(String[] args) {
        new Washer();
    }
}

