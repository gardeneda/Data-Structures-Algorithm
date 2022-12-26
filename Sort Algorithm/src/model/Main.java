package model;

import model.generator.*;
import model.sort.*;

public class Main {

    public static void main(String[] args) {
        int[] arrayRadix = { 4625, 4586, 1330, 8792, 1594, 5729};
        Generator negToPosGen = new negPosIntGenerator();
        Generator posIntGen = new posIntGenerator();

        BubbleSort bubbleSort = new BubbleSort(negToPosGen.generate(10));
        bubbleSort.bubbleSortInitiate();
        bubbleSort.printArray(bubbleSort.getName(), bubbleSort.getArray());
        SelectionSort selectionSort = new SelectionSort(negToPosGen.generate(10));
        selectionSort.selectionSortInitiate();
        selectionSort.printArray(selectionSort.getName(), selectionSort.getArray());
        InsertionSort insertionSort = new InsertionSort((negToPosGen.generate(10)));
        insertionSort.insertionSortInitiate();
        insertionSort.printArray(insertionSort.getName(), insertionSort.getArray());
        ShellSort shellSort = new ShellSort(negToPosGen.generate(10));
        shellSort.shellSortInitiation();
        shellSort.printArray(shellSort.getName(), shellSort.getArray());
        MergeSort mergeSort = new MergeSort(negToPosGen.generate(10));
        mergeSort.mergeSortInitiation(mergeSort.getArray(), 0, mergeSort.getArray().length);
        mergeSort.printArray(mergeSort.getName(), mergeSort.getArray());
        QuickSort quickSort = new QuickSort(negToPosGen.generate(10));
        quickSort.initiateQuickSort(quickSort.getArray(), 0, quickSort.getArray().length);
        quickSort.printArray(quickSort.getName(), quickSort.getArray());
        CountingSort countingSort = new CountingSort(posIntGen.generate(20));
        countingSort.initiateCountingSort(1, 20);
        countingSort.printArray(countingSort.getName(), countingSort.getArray());
        RadixSort radixSort = new RadixSort();
        radixSort.initiateRadixSort(arrayRadix, 10, 4);
        radixSort.printArray("RadixSort", arrayRadix);

//        int i;
//        for (i = 0; i < 5; i++) {
//            System.out.println(i);
//        }
//        System.out.println("Value of this should be 5: " + " " + i);


//        i = 7;
//        System.out.println(i);
//        int j = i/2;
//        System.out.println(j); // 3/2 == 1
//        int k = j/2;
//        System.out.println(k); // 1/2 == 0



//        System.out.println("Factorial value: " + recursiveFactorial(32));
    }

//    public static int iterativeFactorial(int num) {
//
//        if (num == 0) {
//            return 1;
//        }
//
//        int factorial = 1;
//        for (int i = 1; i <= num; i++) {
//            factorial *= i;
//        }
//
//        return factorial;
//    }
//
//    public static int recursiveFactorial(int num) {
//        if (num == 0) {
//            return 1;
//        }
//
//        return num * recursiveFactorial(num -1);
//    }
}


