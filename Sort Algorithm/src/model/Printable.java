package model;

public abstract class Printable {
    private String name;
    private int[] intArray;

    public void printArray(String name, int[] intArray) {
        System.out.print(name + ": ");
        for (int j : intArray) {
            System.out.print(j + " ");
        }
        System.out.println("");
    }
}
