package model.datastructure;

public class Array {
    /*
        - Contiguous block in memory
	    - Every element occupies the same amount of space in memory (because they are all object references)
	    - If an array starts at memory address x, and the size of each element in the array is y,
	      we can calculate the memory address of the ith element by using the following expression:
		        ○ x + i * y
	    - If we know the index of an element, the time to retrieve the element will be the same,
	      no matter where it is in the array

	      Good at retrieving elements from index
	      - 1. Multiply the size of the element by its index
	      - 2. Get the start address of the array
	      - 3. Add the start address to the result of the multiplication

         */
    public Array() {
        int[] intArray = new int[7];
        // Arrays are not a dynamic data structure
        intArray[0] = 20;
        intArray[1] = 35;
        intArray[2] = -15;
        intArray[3] = 7;
        intArray[4] = 55;
        intArray[5] = 1;
        intArray[6] = -22;

        int index = -1;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == 7) {
                index = i;
                break;
            }
        }

        /*
        Address of array[0] = 12 + (0 * 4) = 12
        Address of array[1] = 12 + (1 * 4) = 16
        Address of array[2] = 12 + (2 * 4) = 20
        Address of array[3] = 12 + (3 * 4) = 24
        Address of array[4] = 12 + (4 * 4) = 28
        Address of array[5] = 12 + (5 * 4) = 32
        Address of array[6] = 12 + (6 * 4) = 36
        */
    }
}