package sorting;

import java.util.Arrays;

/**
 * BubbleSort
 *
 * @since 2015-11-16
 */
public class BubbleSort {

    public static void sort(int[] array) {
        boolean notSorted = true;
        while (notSorted) {
            notSorted = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    notSorted = true;
                    ArrayUtils.swap(array, i, i - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 8, 9, 3, 7, 5, 6, 4, 2, 4, 5};
        sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(ArrayUtils.isSortedAscending(array));
    }
}
