package org.example.timeandpacecomlexity;

import java.util.Arrays;
import java.util.Random;

public class TargetInLargeDataSet {

    // Linear Search for target value
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search for target value
    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Utility function to generate random data
    public static int[] generateRandomData(int size) {
        int[] data = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(1000000);
        }
        Arrays.sort(data);
        return data;
    }

    // Function to measure the time taken by Linear and Binary Search
    public static void compareSearchPerformance(int[] data, int target) {
        double startTime = System.nanoTime();
        linearSearch(data, target);
       double linearSearchTime = System.nanoTime() - startTime;

        Arrays.sort(data);

        startTime = System.nanoTime();
        binarySearch(data, target);
        double binarySearchTime = System.nanoTime() - startTime;

        System.out.println("Linear Search Time (ms): " + linearSearchTime/1_000_000.0);
        System.out.println("Binary Search Time (ms): " + binarySearchTime/1_000_000.0);
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        for (int size : sizes) {
            int[] data = generateRandomData(size);
            int target = data[new Random().nextInt(size)];
            System.out.println("\nDataset Size: " + size);
            compareSearchPerformance(data, target);
        }
    }
}
