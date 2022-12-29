import model.BinarySearch;
import model.LinearSearch;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static Random random = new Random();
    public static void main(String[] args) {
        int[] array = randomIntArray(10, 50);
        int value = selectRandomValue(array);
        System.out.println("The value we are searching for is: " + value +
                " and it is found at the index: " + LinearSearch.search(array, value));


        System.out.println("\n\nTesting the Binary Search \n");
        // Testing Binary Search Algorithm

        // Array or given Collections must be sorted before initiating Binary Search
        Arrays.sort(array);
        int sortValue = selectRandomValue(array);

        System.out.println("The value we are searching for is: " + sortValue +
                " and it is found at the index: " + BinarySearch.iterative(array, sortValue));
        for (int number : array) {
            System.out.print(number + " ");
        }
        System.out.println("\n");
        System.out.println("This should return a -1, as it the method is looking for " +
                "a non existent value: Result = " + BinarySearch.iterative(array, -9999));
    }

    /**
     * Returns an integer Array filled with randomly generated integers
     * that will be used by different search algorithms.
     * The capacity of the integer Array can be customized by inputting the
     * wanted capacity in the parameter as an argument, and the range of the integers
     * generated can also be customized, but the lower boundary (or range) cannot be changed from 0.
     * <p></p>
     * @param capacity specifies number of array slots to make
     * @param range upper boundary of the range of random numbers generated (INCLUSIVE)
     * @return An integer array with the
     * specified capacity filled with randomly generated integers within the specified range
     **/
    public static int[] randomIntArray(int capacity, int range) {
        int[] array = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = random.nextInt(range) + 1;
        }

        return array;
    }

    /**
     * Fetches a random integer inside the given integer array.
     * Mainly used for test purposes, because the developer is too lazy
     * to write JUNIT Tests.
     * <p></p>
     * @param input the integer array we're getting our random integer from
     * @return A random integer element that exists within the given integer array
     **/
    public static int selectRandomValue(int[] input) {
        return input[random.nextInt(input.length)];
    }
}