package chap18_strings;

public class A05_DatabaseException extends Exception {
    public A05_DatabaseException(int transactionID,
                                 int queryID, String message) {
        super(String.format("(t%d, q%d) %s", transactionID,
                queryID, message));
    }

    public static void main(String[] args) {
        try {
            throw new A05_DatabaseException(3, 7, "Write failed");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
