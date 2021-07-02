package chap34_collectiontopics;

// Demonstration of Stack Class

import java.util.*;

enum Month {
    JANUARY, FEBRUARY, MARCH, APRIL,
    MAY, JUNE, JULY, AUGUST, SEPTEMBER,
    OCTOBER, NOVEMBER
}

class Stacks {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (Month m : Month.values())
            stack.push(m.toString());
        System.out.println("\nstack = " + stack);

        // Treating a stack as a Vector:
        stack.addElement("The last line");
        System.out.println(
                "element 5 = " + stack.elementAt(5));
        System.out.println("\npopping elements:");
        while (!stack.empty())
            System.out.print(stack.pop() + " ");

        // Using a LinkedList as a Stack:
        LinkedList<String> lstack = new LinkedList<>();
        for (Month m : Month.values())
            lstack.addFirst(m.toString());
        System.out.println("\nlstack = " + lstack);
        while (!lstack.isEmpty())
            System.out.print(lstack.removeFirst() + " ");

        // Using the Stack class from
        // the Collections Chapter:
        onjava.Stack<String> stack2 =
                new onjava.Stack<>();
        for (Month m : Month.values())
            stack2.push(m.toString());
        System.out.println("\nstack2 = " + stack2);
        while (!stack2.isEmpty())
            System.out.print(stack2.pop() + " ");
    }
}

public class A13_Stacks {
}
