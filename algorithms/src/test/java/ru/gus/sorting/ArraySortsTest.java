package ru.gus.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ArraySortsTest {

    @Test
    public void whenMergeSortThenTrue() {
        ArraySorts sorter = new ArraySorts();
        int[] input = {2, 5, 2, 3, 6, 77, 22, 55, 67, 9, 1};
        int[] result = sorter.mergeSort(input);
        int[] expected = {1, 2, 2, 3, 5, 6, 9, 22, 55, 67, 77};
        assertThat(result, is(expected));
    }

    @Test
    public void whenBubbleSortThenTrue() {
        ArraySorts sorter = new ArraySorts();
        int[] input = {2, 5, 2, 3, 6, 77, 22, 55, 67, 9, 1};
        int[] result = sorter.bubbleSort(input);
        int[] expected = {1, 2, 2, 3, 5, 6, 9, 22, 55, 67, 77};
        assertThat(result, is(expected));
    }

    @Test
    public void whenInsertSortThenTrue() {
        ArraySorts sorter = new ArraySorts();
        int[] input = {2, 5, 2, 3, 6, 77, 22, 55, 67, 9, 1};
        int[] result = sorter.insertionSort(input);
        int[] expected = {1, 2, 2, 3, 5, 6, 9, 22, 55, 67, 77};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSelectionSortThenTrue() {
        ArraySorts sorter = new ArraySorts();
        int[] input = {2, 5, 2, 3, 6, 77, 22, 55, 67, 9, 1};
        int[] result = sorter.selectionSort(input);
        int[] expected = {1, 2, 2, 3, 5, 6, 9, 22, 55, 67, 77};
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuickSortThenTrue() {
        QuickSort sorter = new QuickSort();
        Integer[] input = {2, 5, 2, 3, 6, 77, 22, 55, 67, 9, 1};
        sorter.sort(input);
        Integer[] expected = {1, 2, 2, 3, 5, 6, 9, 22, 55, 67, 77};
        assertThat(input, is(expected));
    }

}