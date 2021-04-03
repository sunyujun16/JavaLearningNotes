package chap12_Collections;

import java.util.LinkedList;
import java.util.Queue;

class Command {
    String s;

    public Command(String s) {
        this.s = s;
    }

    void operation() {
        System.out.print(s);
    }
}

public class E27_PassQueue {
    Queue<Command> fillQueue(Command... cs) {
        Queue<Command> commands = new LinkedList<>();
        for (Command c : cs) {
            commands.add(c);
        }
        return commands;
    }

    public static void main(String[] args) {
        E27_PassQueue pq = new E27_PassQueue();
        Queue<Command> commands = pq.fillQueue(
                new Command("Sunyujun"),
                new Command("Liuyihan"),
                new Command("Wangzuxian")
        );
        Consumer.consum(commands);
    }
}

class Consumer {
    static void consum(Queue<Command> commands) {
        while (commands.peek() != null) {
//            System.out.println(commands.remove());
            commands.remove().operation();
            System.out.println(" is removed.");
        }
    }
}