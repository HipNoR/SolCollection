package ru.gus.sorting;


import java.util.Arrays;
import java.util.Random;

/**
 * Merge sorting class.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 12.01.2019
 */
public class ArraySorts {


    /**
     * Merge sort O(n*log n).
     * @param array
     * @return
     */
    public int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        } else {
            int border = array.length / 2;
            int[] left = Arrays.copyOfRange(array, 0, border);
            int[] right = Arrays.copyOfRange(array, border, array.length);
            left = mergeSort(left);
            right = mergeSort(right);
            int[] result = new int[left.length + right.length];
            int lCount = 0;
            int rCount = 0;
            for (int i = 0; i < result.length; i++) {
                if (lCount == left.length) {
                    result[i] = right[rCount++];
                    continue;
                }
                if (rCount == right.length) {
                    result[i] = left[lCount++];
                    continue;
                }

                if (left[lCount] < right[rCount]) {
                    result[i] = left[lCount++];
                } else {
                    result[i] = right[rCount++];
                }
            }
            return result;
        }
    }

    /**
     * Bubble sort O(n^2).
     * @param array
     * @return
     */
    public int[] bubbleSort(int[] array) {
        int temp;
        for (int out = array.length - 1; out > 0; out--) {
            for (int in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    temp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * Insertion sort O(n^2).
     * @param array
     * @return
     */
    public int[] insertionSort(int[] array) {
        int rIndex = 0;
        int temp;
        for (int sortIndex = 1; sortIndex < array.length; sortIndex++) {
            temp = array[sortIndex];
            if (temp < array[sortIndex - 1]) {
                for (int i = 0; i < sortIndex; i++) {
                    if (temp < array[i]) {
                        rIndex = i;
                        break;
                    }
                }
                for (int i = sortIndex; i > rIndex; i--) {
                    array[i] = array[i - 1];
                }
                array[rIndex] = temp;
            }
        }
        return array;
    }

    /**
     * Selection sort O(n^2).
     * @param array
     * @return
     */
    public int[] selectionSort(int[] array) {
        int curSmall;
        int smallIndex;
        for (int sortIndex = 0; sortIndex < array.length; sortIndex++) {
            curSmall = array[sortIndex];
            smallIndex = sortIndex;
            for (int i = sortIndex + 1; i < array.length; i++) {
                if (array[i] < curSmall) {
                    curSmall = array[i];
                    smallIndex = i;
                }
            }
            for (int i = smallIndex; i > sortIndex; i--) {
                array[i] = array[i - 1];
            }
            array[sortIndex] = curSmall;
        }
        return array;
    }

}
