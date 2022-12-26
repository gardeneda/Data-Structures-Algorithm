package model.sort;

import model.Printable;

public class BubbleSort implements Printable {
    private int[] intArray;

    /*
    performance degrades quickly as the number of items you need to sort grows
    partitions the data (array) into a sorted partition and an unsorted partition.
    logical partition, we don't create separate array instances, we just use the array that we are sorting

    called bubble sort because depending on which way you're sorting will bubble up or down to the array

    "in-place algorithm"
    - Don't have to create a new array to perform the sort

    O(n^2) time complexity

    */

    public BubbleSort(int[] array) {
        intArray = array;
    }

    public void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void bubbleSortInitiate() {
        // intArray.length - 1
        // the -1 exists because we need to use it as the running-condition for the inner for-loop.
        // Then why not just use this condition as the inner for-loop? Because we need to repeat it that many times.
        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0;
             lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                }
            }
        }
    }

    public String getName() {
        return "BubbleSort";
    }

    public int[] getArray() {
        return this.intArray;
    }
}
