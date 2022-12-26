package model.sort;

import model.Printable;

public class QuickSort extends Printable {
    private int[] intArray;

    public QuickSort(int[] input) {
        this.intArray = input;
    }

    public void initiateQuickSort(int[] input, int start, int end) {
        // This is a one-element array
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition(input, start, end);
        initiateQuickSort(input, start, pivotIndex);
        initiateQuickSort(input, pivotIndex + 1, end);
    }

    public int partition(int[] input, int start, int end) {
        // This is using the first element as the pivot
        int pivot = input[start];
        int i = start;
        int j = end;
        while (i < j) {

            // NOTE: Empty-loop body: --j is used because variable end is 1 greater than the actual range of the array
            while (i < j && input[--j] >= pivot);
            if (i < j) {
                input[i] = input[j];
            }

            // NOTE: Empty-loop body
            while (i < j && input[++i] <= pivot);
            if (i < j) {
                input[j] = input[i];
            }
        }
        input[j] = pivot;
        return j;
    }

    public String getName() {
        return "QuickSort";
    }

    public int[] getArray() {
        return this.intArray;
    }
}
