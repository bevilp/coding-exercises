package sorting;

import java.util.Arrays;

/**
 * SelectionSort
 *
 * @since 2015-11-16
 */
public class SelectionSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int smallest = array[i];
            int smallestIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < smallest) {
                    smallest = array[j];
                    smallestIndex = j;
                }
            }
            ArrayUtils.swap(array, i, smallestIndex);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 8, 9, 3, 7, 5, 6, 4, 2, 4, 5};
        sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(ArrayUtils.isSortedAscending(array));

    }
}
