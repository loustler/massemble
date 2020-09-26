package io.loustler.massemble.jsort;

import io.loustler.massemble.JArraySwap;
import io.loustler.massemble.JPrinter;
import io.loustler.massemble.JRandom;

public class JQuickSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        quicksort(arr, 0, arr.length - 1);
    }

    public static void sortRP(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        quicksortWithRandomPivot(arr, 0, arr.length - 1);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];

        System.out.printf("pivot is %d\n", pivot);

        int i = left - 1;

        for (int j = left; j < right; j++)
            if (arr[j] < pivot)
                JArraySwap.swap(arr, ++i ,j);

        JArraySwap.swap(arr, ++i, right);

        return i;
    }

    private static void quicksortWithRandomPivot(int[] arr, int left, int right) {
        int pivot = JRandom.nextInt(right - left) + left;

        JArraySwap.swap(arr, pivot, right);

        quicksort(arr, left, right);
    }

    private static void quicksort(int[] arr, int left, int right) {
        if (left >= right) return;

        int partitionIndex = partition(arr, left, right);

        quicksort(arr, left, partitionIndex - 1);
        quicksort(arr, partitionIndex, right);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 6, 2, 3, 7, 9};
        sort(arr);
        JPrinter.print(arr);

        int[] arr2 = new int[]{1, 5, 6, 2, 3, 7, 9};
        sortRP(arr2);
        JPrinter.print(arr2);
    }
}
