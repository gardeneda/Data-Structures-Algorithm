package model.sort;

import model.Printable;

public class CountingSort implements Printable {
    private int[] array;


    public CountingSort(int[] intArray) {
        array = intArray;
    }

    // All the values fall within the range min to max, therefore it is included in the parameter
    public void initiateCountingSort(int min, int max) {

        int[] countArray = new int[(max - min) + 1];

        for (int i = 0; i < array.length; i++) {
            // (input[i] - min) corresponds to the value of the input value;
            // ++'ing it means that it counts the number of each specific value in the original array
            // This works because the value of min is 1
            countArray[array[i] - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                // Writes the i value to the original array
                array[j++] = i;
                countArray[i - min]--;
            }
        }
    }

    public void initiateStableCountingSort() {

    }

    public int[] getArray() {return this.array;}

    public String getName() {return "Counting Sort";}
}
