package model.sort;

import model.Printable;

public class ShellSort extends Printable {
    private int[] intArray;
    /*
    A variation of the InsertionSort
    Uses the Knuth Sequence to create a 'gap' that breaks the number of sequence down into smaller accounts,
    essentially decreasing the necessary steps to sort a specific array of data.

    "in-place" algorithm
    - Don't have to create a new array to perform the sort

    Worst Case: O(n^2) time complexity

    Unstable algorithm
    - Depending on the gap the data point could be shifted and its position not kept
     */

    public ShellSort(int[] array) {
        intArray = array;
    }

    public void shellSortInitiation() {
        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < intArray.length; i++) {
                int newElement = intArray[i];

                int j = i;

                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }

                intArray[j] = newElement;
            }
        }
    }

    public String getName() {
        return "ShellSort";
    }

    public int[] getArray() {
        return this.intArray;
    }
}
