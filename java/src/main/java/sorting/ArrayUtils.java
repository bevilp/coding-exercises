package sorting;

import java.util.Arrays;

/**
 * ArrayUtils
 *
 * @since 2015-11-16
 */
public final class ArrayUtils {

    public static boolean isSortedAscending(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * swap array[index1] with array[index2]
     *
     * @param array
     * @param index1
     * @param index2
     */
    public static int[] swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }

    public static int[] reverse(int[] array) {
        for (int i = 0, j = array.length - 1; i < array.length / 2; i++, j--) {
            swap(array, i, j);
        }
        return array;
    }
}
