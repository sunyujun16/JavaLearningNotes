package chap16_validating;


// Using the class loader to enable assertions
// {ThrowsException}
public class LoaderAssertions {
    public static void main(String[] args) {

        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true); // 可以这样启用断言.

        /* 或者这样:
        static {
            boolean assertionsEnabled = false;
            // Note intentional side effect of assignment:
            assert assertionsEnabled = true;
            if(!assertionsEnabled)
                throw new RuntimeException("Assertions disabled");
               }
        */

        new Loaded().go();
    }
}

class Loaded {
    public void go() {
        assert false : "Loaded.go()";
    }
}
/* Output:
___[ Error Output ]___
Exception in thread "main" java.lang.AssertionError: Loaded.go()
at Loaded.go(LoaderAssertions.java:15)
at LoaderAssertions.main(LoaderAssertions.java:9)
*/
