package chap21_arrays;

import java.util.*;

import onjava.*;

import static onjava.ArrayShow.*;

class ParallelPrefix1 {
    public static void main(String[] args) {
        int[] nums = new Count.Pint().array(10);
        show(nums);

        System.out.println(Arrays.stream(nums)
                .reduce(Integer::sum).getAsInt()); // 只生成一个结果.

        Arrays.parallelPrefix(nums, Integer::sum);
        show(nums); // 保存了每一步的结果

        System.out.println(Arrays.stream(
                new Count.Pint().array(6))
                .reduce(Integer::sum).getAsInt()); // 12345的和.
    }
}

public class A21_ParallelPrefix1 {
}
