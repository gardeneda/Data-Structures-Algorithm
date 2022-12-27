package model;

public class LinearSearch {

    public LinearSearch() {

    }

    /**
     * Perform a linear search by iterating through each item inside an integer array.
     * <p></p>
     * @param input the integer array that needs to be searched for the value
     * @param value the value that needs to be located
     * @return An integer that denotes the index of where the value is inside the integer array.
     * If the function returns -1, the value does not exist inside the given array.
     **/
    public static int search(int[] input, int value) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == value) {
                return i;
            }
        }

        return -1;
    }
}
