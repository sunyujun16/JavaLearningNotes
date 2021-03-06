package ch01_Fundation_01;

import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class BinarySearch
{
    public static void main(String[] args)
    {
        //noinspection deprecation
        int[] whitelist = In.readInts(args[0]);

        Arrays.sort(whitelist);

        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();

            if (rank(key, whitelist) == -1)
                StdOut.println(key);
        }
    }


    private static int rank(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
