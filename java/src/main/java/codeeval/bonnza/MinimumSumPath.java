package codeeval.bonnza;

import java.util.Scanner;

/**
 * MinimumSumPath
 *
 * @since 2015-12-02
 */
public class MinimumSumPath {


/*
Input:
2
4,6
2,8
3
1,2,3
4,5,6
7,8,9

Output:
14
21


*/

/*

    int minCost(int cost[R][C], int m, int n)
{
   if (n < 0 || m < 0)
      return INT_MAX;
   else if (m == 0 && n == 0)
      return cost[m][n];
   else
      return cost[m][n] + min( minCost(cost, m-1, n-1),
                               minCost(cost, m-1, n),
                               minCost(cost, m, n-1) );
}
*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                matrix[i] = toIntArray(scanner.next().split(","));
            }
            System.out.println(shortestPath(matrix, 0, 0, 0));
        }
    }

    private static int[] toIntArray(String[] stringArray) {
        int[] array = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            array[i] = Integer.valueOf(stringArray[i]);
        }
        return array;
    }

    private static int shortestPath(int[][] array, int currentRow, int currentColumn, int currentPathSum) {
        if (currentRow >= array.length || currentColumn >= array[0].length) {
            return Integer.MAX_VALUE;
        } else if (currentRow == array.length - 1 && currentColumn == array[0].length - 1) {
            return currentPathSum + array[currentRow][currentColumn];
        } else {
            int down = shortestPath(array, currentRow + 1, currentColumn, currentPathSum);
            int right = shortestPath(array, currentRow, currentColumn + 1, currentPathSum);
            return currentPathSum + array[currentRow][currentColumn] + (down < right ? down : right);
        }
    }
}
