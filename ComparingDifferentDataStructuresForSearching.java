package org.example.timeandpacecomlexity;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class ComparingDifferentDataStructuresForSearching {

    // Linear Searching in array
    public static int arraySearching(int[] num, int target) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Search element using hashSet dataStructure
    public static boolean searchUsingHashSet(int[] num, int target) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            if (hs.contains(target)) {
                return true;
            } else {
                hs.add(num[i]);
            }
        }
        return false;
    }

    // Searching using TreeSet
    public static boolean searchUsingTreeSet(int[] num, int target) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < num.length; i++) {
            if (ts.contains(target)) {
                return true;
            } else {
                ts.add(num[i]);
            }
        }
        return false;
    }

    // Function to compare search time for Array, HashSet, and TreeSet
    public static void compareSearchTimes(int[] num, int target) {
        long startTime, endTime;

        // Array Search
        startTime = System.nanoTime();
        arraySearching(num, target);
        endTime = System.nanoTime();
        long arrayTime = endTime - startTime;

        // HashSet Search
        startTime = System.nanoTime();
        searchUsingHashSet(num, target);
        endTime = System.nanoTime();
        long hashSetTime = endTime - startTime;

        // TreeSet Search
        startTime = System.nanoTime();
        searchUsingTreeSet(num, target);
        endTime = System.nanoTime();
        long treeSetTime = endTime - startTime;

        // Output the time taken by each method
        System.out.println("Array Search Time: " + arrayTime/1000000.0 + " ms");
        System.out.println("HashSet Search Time: " + hashSetTime/1000000.0 + " ms");
        System.out.println("TreeSet Search Time: " + treeSetTime/1_000_000.0 + " ms");
    }

    public static void main(String[] args) {
        Random random = new Random();

        // Test with different dataset sizes (1,000, 100,000, and 1,000,000)
        int[] dataset1k = new int[1000];
        int[] dataset100k = new int[100000];
        int[] dataset1M = new int[1000000];

        // Fill datasets with random values
        for (int i = 0; i < dataset1k.length; i++) {
            dataset1k[i] = random.nextInt(1000000) + 1;
        }
        for (int i = 0; i < dataset100k.length; i++) {
            dataset100k[i] = random.nextInt(1000000) + 1;
        }
        for (int i = 0; i < dataset1M.length; i++) {
            dataset1M[i] = random.nextInt(1000000) + 1;
        }

        // Random target value from each dataset
        int target1k = dataset1k[random.nextInt(dataset1k.length)];
        int target100k = dataset100k[random.nextInt(dataset100k.length)];
        int target1M = dataset1M[random.nextInt(dataset1M.length)];

        // Compare the search times for different data structures with datasets of varying sizes
        System.out.println("Testing with 1,000 elements:");
        compareSearchTimes(dataset1k, target1k);

        System.out.println("\nTesting with 100,000 elements:");
        compareSearchTimes(dataset100k, target100k);

        System.out.println("\nTesting with 1,000,000 elements:");
        compareSearchTimes(dataset1M, target1M);
    }
}
