package ru.gus.sorting;


import java.util.Random;

/**
 * QuickSort class
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 15.01.2019
 */
public class QuickSort<T extends Comparable<T>> {
    private Random r = new Random();

    public void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(T[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = r.nextInt((right - left) + 1) + left;
            int newPivot = partition(array, left, right, pivotIndex);

            quickSort(array, left, newPivot - 1);
            quickSort(array, newPivot + 1, right);
        }
    }

    private int partition(T[] array, int left, int right, int pivotIndex) {
        T pivotValue = array[pivotIndex];
        swap(array, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (array[i].compareTo(pivotValue) < 0) {
                swap(array, i, storeIndex);
                storeIndex++;
            }
        }
        swap(array, storeIndex, right);
        return storeIndex;
    }

    private void swap(T[] array, int first, int second) {
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

}
