package model.sort;

import model.Printable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort implements Printable {
    private int[] intArray;

    public BucketSort(int[] array) {
        this.intArray = array;
    }

    public void initiateBucketSort(int[] input) {
        // We are assuming that we're only taking integers from 1~99.
        // By this, we can divide the buckets into 10, each 10s a bucket of its own.
        // Remember, this is a simple demonstration of the implementation of a BucketSort.
        // Assumption is what makes bucket sort O(n).
        List<Integer>[] buckets = new List[10];

        for (int i = 0; i < buckets.length; i++) {
            // Using Array List for buckets
            buckets[i] = new ArrayList<Integer>();
            // Using Linked List for buckets
            // buckets[i] = new LinkedList<Integer>();
        }

        // Scattering Phase
        for (int i = 0; i < input.length; i++) {
            buckets[hash(input[i])].add(input[i]);
        }

        // Sort items in each bucket
        for (List bucket: buckets) {
            Collections.sort(bucket);
        }

        // Gathering Phase
        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int value: buckets[i]) {
                input[j++] = value;
            }
        }
    }

    // Hashing function needed to scatter the items into a bucket.
    // Remember that we need to be able to just concatenate all the buckets as it is.
    private int hash(int value) {
        return value / (int) 10;
    }

    public String getName() {return "Bucket Sort";}

    public int[] getArray() {
        return intArray;
    }
}
