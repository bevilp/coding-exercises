package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @since 2015-10-29
 */
class Solution {

    public static void main(String[] argh) {
        Adder X = new Adder();
        System.out.println("My superclass is: " + X.getClass().getSuperclass().getName());
        System.out.print(X.add(10, 32) + " " + X.add(10, 3) + " " + X.add(10, 10) + "\n");

        List<Integer> intList = new ArrayList<>();
        intList.stream().reduce(0, Integer::sum);

    }

    private static class Arithmetic {

    }

    private static class Adder extends Arithmetic {

        public int add(int num1, int num2) {
            return num1 + num2;
        }

    }
}