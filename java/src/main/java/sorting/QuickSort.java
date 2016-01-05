package sorting;

import java.util.Scanner;

/**
 * QuickSort
 *
 * @since 2015-11-27
 */
public class QuickSort {

    public static void sort(int[] array, int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
        // Divide into two arrays
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                ArrayUtils.swap(array, i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j) {
            sort(array, lowerIndex, j);
        }
        if (i < higherIndex) {
            sort(array, i, higherIndex);
        }
    }
}
