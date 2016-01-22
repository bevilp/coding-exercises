package leetcode;

import java.util.Scanner;

/**
 * ArraySum
 *
 * @since 2015-10-30
 */
public class ArraySum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numNums = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < numNums; i++) {
            sum += scanner.nextInt();
        }
        System.out.println(sum);
    }
}
