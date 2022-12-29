package model;

public class BinarySearch {
    private int[] intArray;


    public BinarySearch(int[] array) {
        this.intArray = array;
    }

    public static int iterativeBinarySearch(int[] input, int value) {
        int start = 0;
        int end = input.length;

        // If start == end, then we searched the entire array
        while (start < end) {
            int midpoint = (start + end) / 2;
            if (input[midpoint] == value) {
                return midpoint;
            }
            // Checks if input at midpoint is less than the search value
            // Which means that they have to search the right divided section
            // The end will be the same, but our start value has to change
            else if (input[midpoint] < value) {
                start = midpoint + 1;
            }
            // Midpoint is always 1 greater than the search value, so we have to
            // search the left split array
            else {
                end = midpoint;
            }
        }

        // If no value is found
        return -1;
    }
}
