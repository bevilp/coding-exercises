package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

/**
 * Java1DArrayHard
 *
 * @since 2015-10-30
 */
public class Java1DArrayHard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        for (int i = 0; i < arrayLength; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] path = new int[n];
            for (int j = 0; j < n; j++) {
                path[j] = scanner.nextInt();
            }
            solve(path, m);
        }
    }

    @Test
    public void testCanWin() {
        Assert.assertEquals("YES", solve(new int[] {0, 0, 0, 0, 0}, 3));
        Assert.assertEquals("YES", solve(new int[] {0, 0, 0, 1, 1, 1}, 5));
        Assert.assertEquals("NO", solve(new int[] {0, 0, 1, 1, 1, 0}, 3));
        Assert.assertEquals("NO", solve(new int[] {0, 1, 0}, 1));

        Assert.assertEquals("YES", solve(new int[] {0, 1, 0, 1, 0, 1}, 2));
        Assert.assertEquals("NO", solve(new int[] {0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, 6));
        Assert.assertEquals("YES", solve(new int[] {0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, 3));
    }

    private static String solve(int[] ints, int m) {
        List<Integer> visitedIndexes = new ArrayList<>();
        boolean solved = canWin(ints.length, m, 0, ints, visitedIndexes);
        return solved ? "YES" : "NO";
    }

    private static boolean canWin(int n, int m, int current, int[] ints, List<Integer> visitedIndexes) {
        if (visitedIndexes.contains(current)) {
            return false;
        }

        visitedIndexes.add(current);
        if (current >= n) {
            return true;
        } else if (current < 0) {
            return false;
        } else if (ints[current] == 1) {
            return false;
        } else {
            return canWin(n, m, current + m, ints, visitedIndexes) || canWin(n, m, current + 1, ints, visitedIndexes)
                    || canWin(n, m, current - 1, ints, visitedIndexes);
        }
    }

}
