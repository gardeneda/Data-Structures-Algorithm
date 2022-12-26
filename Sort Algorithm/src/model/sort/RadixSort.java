package model.sort;

import model.Printable;

public class RadixSort implements Printable {

    public RadixSort() {}

    public void initiateRadixSort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            singleRadixSort(input, i, radix);
        }
    }

    public void singleRadixSort(int[] input, int position, int radix) {

        // Indicates the number of times we're sorting.
        int numItems = input.length;

        int[] countArray = new int[radix];

        for (int value: input) {
            countArray[getDigit(position, value, radix)]++;
        }

        // The number of values that have 0 or less in their (1) position are going to be
        // the number of values that have 0, so we don't have to worry about changing the first count
        // We only need to care about 1 and beyond.

        // Adjusting the count array
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j -1];
        }

        int[] temp = new int[numItems];
        // Remember that we start from the rightmost element
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            // The -- prefix decreases the adjusted count value at the countArray index
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }

    public int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(10, position) % radix;
    }
}
