package model.sort;

import model.Printable;

public class InsertionSort implements Printable {
    private int[] intArray;
    /*
    Has Unsorted and Sorted partitions like the BubbleSort and SelectionSort
    Has the tendency to grow the partition from left to right

    Starts by stating that the first element is in the sorted partition
    (so that means that the unsorted partition i starts at 1; int unsortedPartitionIndex = 1)

    Compare the value being inserted with the values in the unsorted partition
    Grows the sorted partition from left to right

    "in-place" algorithm
     - Don't have to create a new array to perform the sort

    O(n^2) time complexity
    Stable Algorithm
     - We pick up elements from the leftmost first and we stop at the first duplicate element we see in the
     sorted partition, and it will be placed in the right. So the order of the duplicate elements will stay the same.

     */

    public InsertionSort(int[] array) {
        intArray = array;

    }

    public void insertionSortInitiate() {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {

            int newElement = intArray[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }
            intArray[i] = newElement;
        }
    }

    public String getName() {
        return "InsertionSort";
    }

    public int[] getArray() {
        return this.intArray;
    }
}
