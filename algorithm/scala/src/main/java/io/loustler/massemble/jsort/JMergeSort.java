package io.loustler.massemble.jsort;

import io.loustler.massemble.JPrinter;

public class JMergeSort {
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // two pointer
        while (i < left.length && j < right.length)
            arr[k++] = left[i] < right[j] ? left[i++] : right[j++];

        while (i < left.length)
            arr[k++] = left[i++];

        while (j < right.length)
            arr[k++] = right[j++];
    }

    public static void sort(int[] arr) {
        if (arr.length <= 1) return;

        int mid = arr.length / 2;

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < left.length; i++)
            left[i] = arr[i];
        for (int i = 0; i < right.length; i++)
            right[i] = arr[mid + i];

        sort(left);
        sort(right);

        merge(arr, left, right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 8, 6, 7};
        sort(arr);
        JPrinter.print(arr);
    }
}
