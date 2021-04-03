package chap11_InnerClass;


// Holds a sequence of Objects
interface Counter {
    int next();
}

/**
 * @noinspection ALL
 */
public class A17_Local_InnerClass {
    private int count = 0;

    Counter getCounter(final String name) {
        // A local inner class:
        class LocalCounter implements Counter {
            LocalCounter() {
                // Local inner class can have a constructor
                System.out.println("LocalCounter()");
            }

            @Override
            public int next() {
                System.out.print(name); // Access local final
                return count++;
            }
        }
        return new LocalCounter();
    }

    // Repeat, but with an anonymous inner class:
    Counter getCounter2(final String name) {
        return new Counter() {
            // Anonymous inner class cannot have a named
            // constructor, only an instance initializer:
            {
                System.out.println("Counter()");
            }

            @Override
            public int next() {
                System.out.print(name); // Access local final
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        A17_Local_InnerClass lic = new A17_Local_InnerClass();
        Counter
                c1 = lic.getCounter("Local inner "),
                c2 = lic.getCounter2("Anonymous inner ");
        for (int i = 0; i < 5; i++)
            System.out.println(c1.next()); // 注意副作用是打印名字, 返回值也被打印出来
        for (int i = 0; i < 5; i++)
            System.out.println(c2.next());
    }
}

