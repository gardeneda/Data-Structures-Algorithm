package model;

public class BinarySearch {
    private int[] intArray;


    public BinarySearch(int[] array) {
        this.intArray = array;
    }

    /**
     * Iterative version of the Binary Search algorithm:
     * Searches for an integer value in the given integer array.
     * Time complexity is O(log n).
     * <p></p>
     * @param input a sorted Integer Array
     * @param value the integer value being searched for
     * @return the index of the value, if return value -1 the value does not exist in the array.
     **/
    public static int iterative(int[] input, int value) {
        int start = 0;
        int end = input.length;

        // If start == end, then we searched the entire array
        while (start < end) {
            int midpoint = (start + end) / 2;
            if (input[midpoint] == value) {
                return midpoint;
            }
            // Checks if input at midpoint is less than the search value
            // If true, it means that they have to search the right divided section
            // The end will be the same, but our start value has to change
            else if (input[midpoint] < value) {
                start = midpoint + 1;
            }
            // Midpoint is always 1 greater than the search value,
            // because we're looking at the case where Midpoint is greater
            // than the search value, so we have to
            // search the left split array
            else {
                end = midpoint;
            }
        }

        // If no value is found
        return -1;
    }
}
