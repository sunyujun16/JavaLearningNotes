package ch01_Fundation_03_bag_queue_stack;



public class ResizingArrayQueueOfStrings {
    private int n;
    private String[] arq;



    public ResizingArrayQueueOfStrings(int length) {
        arq = new String[length];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull(){
        return n == 10;
    }


    public static void main(String[] args) {
        System.out.println("Test of RAQOS.");
    }


}
