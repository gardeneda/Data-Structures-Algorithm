package model.sort;

/*
Divide and Conquer Algorithm

Has two major phases;
- Splitting
    - Causes the sorting to be faster during the merging phase
   -  We don't create new arrays in this case; Splitting is logical
      (We use indexes to keep track where the array ahs been split)
- Merging


Splitting Phase:
    - Start with an unsorted array, and divides it into two arrays.
    - If the number of arrays is odd, we would put it in the left or right array
    depending on the implementation.
    - The first array is the "left array" and the second array, "right array"
    - We then split the "left array" into two, and the "right array" into two.
      This process is continued until
      we split the original array into 1 element arrays
        * A 1 element array is sorted by default,
        because there's only one element in it

Merging Phase:
    - Merge every left/right pair into a sorted array
    - This is done by creating a temporary array large enough to hold all of the elements in the array we're merging
        * This is why lots of temporary arrays are made, and thus cause some overloading in memory
    - We set i to be the first index of the left array and j to be the first index of the right array
    - We then compare left[i] to right[j]
        * If left is smaller we copy it to the temp array and increment i by 1.
        * If right is smaller, we copy it to the temp array and increment j by 1.
    - Repeat this process until a single sorted array is left.
    - Not in-place, because it uses temporary arrays.

Time Complexity: O(n log n) - base 2
Stable Sort Algorithm - because we check if the element in the right is greater

Lots of temporary array is made, so if memory is an issue - may not be that useful
 */


import model.Printable;

public class MergeSort extends Printable {
    private int[] intArray;

    public MergeSort(int[] input) {
        intArray = input;
    }

    // EFFECTS: recursive function to sort an algorithm in ascending order
    // MODIFIES: int[] intArray
    public void mergeSortInitiation(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        // Partition phase
        int mid = (start + end) / 2;
        mergeSortInitiation(input, start, mid);
        mergeSortInitiation(input, mid, end);
        merge(input, start, mid, end);
    }

    public void merge(int[] input, int start, int mid, int end) {
        // Think of the very-end of the branch;
        if (input[mid-1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        // Create temp array, store the sorted numbers, and replace the values in the original array with them.
        int[] temp = new int[end-start];

        while (i < mid && j < end) {
            // How would we move the temp index to the original list without the function below?
            temp[tempIndex++] = (input[i] <= input[j]) ? input[i++] : input[j++];
        }

        // We copy just the thing that we need to move over to (when the biggest number is in the left array)
        // (sourceArray, startPosition, destinationArray, destinationIndex, length)
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        // startPosition can be i. If there are leftover arrays in the left array,
        //      this will be the first index of the element we haven't handled.
        // start + tempIndex = tempIndex counts how many elements were handled,
        //      so the destination position for any elements in the left array that are gonna basically
        //      jump over all of the elements in the temporary array is this.
        //      ** We copy the left over elements from the left partition directly into where they'd end up in original array
        //      ** We don't care about the left-over from the right partition, because they should already be the largest value.
        //      ** This means that there's no point in copying that specific value.
        //mid - i = the number of left over elements from the left partition. If we traversed through all of the left array,
        //      then this would be 0 and the code will execute to do nothing.

        System.arraycopy(temp, 0, input, start, tempIndex);
        // startPosition is 0 because we want to copy from the beginning.
    }

    public String getName() {
        return "MergeSort";
    }

    public int[] getArray() {
        return this.intArray;
    }

    public void setArray(int[] input) {
        this.intArray = input;
    }
}
