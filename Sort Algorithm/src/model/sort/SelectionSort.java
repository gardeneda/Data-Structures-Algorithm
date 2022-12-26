package model.sort;

import model.Printable;

public class SelectionSort extends Printable {
    private int[] intArray;
    /*
    Goes through the list and places the largest number at the very end (greatest i value)
    Every time it places the largest number at the end, it reduces the (i) value that becomes decremented.

    "in-place algorithm"
    - Don't have to create a new array to perform the sort

    Is an unstable algorithm

    O(n^2) time complexity
     */

    public SelectionSort(int[] array) {
        intArray = array;
    }

    public void selectionSortInitiate() {
        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;
            // Position 0 is the largest number, because that is our assumption - hence why i = 1
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[largest]) {
                    largest = i;
                }
            }
            swap(intArray, lastUnsortedIndex, largest);
        }
    }

    public void swap(int[] intArray, int unsorted, int largest) {
        // This is what makes this a STABLE ALGORITHM
        if (unsorted == largest) {
            return;
        }
        // Remember that the value of Unsorted, is the last element of the
        int temp = intArray[unsorted];
        intArray[unsorted] = intArray[largest];
        // The value where the largest value was is put into the switched value's position
        intArray[largest] = temp;
    }

    public String getName() {
        return "SelectionSort";
    }

    public int[] getArray() {
        return this.intArray;
    }
}
