package chap06_ImplementationHiding;

class Connection {
    private static int num = 0;
    private int tag;

    Connection() {
        System.out.println("Connection instance generating " + num);
        tag = num;
//        num+=1;
    }

    static void increaseNum() {
        num += 1;
    }

    @Override
    public String toString() {
        return "I am connection" + tag;
    }
}

public class E08_ConnectionManager {
    //    private static Connection[] conArray;
    private static int maxNum = 10;

    public E08_ConnectionManager() {
        System.out.println("Manager online.");
    }

    public static Connection[] makeArray(int n) {
        Connection[] conArray = new Connection[n];

        for (int i = 0; i <= n - 1; i++) {
            if (maxNum <= 0) {
                System.out.println("You're asking too much, bitch. Top is 10.");
                conArray[i] = null;
                continue;
            }
            conArray[i] = new Connection();
            Connection.increaseNum(); // so static methods can be called more than once.
            maxNum--;
        }

        return conArray;
    }

    public static void showConnections(Connection[] ca) {
        int count = 0;

        for (Connection c : ca) {
            System.out.println(c);
            if (c == null) System.out.println("nothing in this one. index: " + count);
            count++;
        }
    }

    public static void main(String[] args) {
//        E08_ConnectionManager ea = new E08_ConnectionManager();

        Connection[] conAr = makeArray(12);

        showConnections(conAr);

    }

}
