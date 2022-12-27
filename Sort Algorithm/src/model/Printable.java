package model;

public interface Printable {

    default void printArray(String name, int[] intArray) {
        System.out.print(name + ": ");
        for (int j : intArray) {
            System.out.print(j + " ");
        }
        System.out.println("");
    }
}
