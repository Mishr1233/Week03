package org.example.timeandpacecomlexity;


import java.util.Arrays;
import java.util.Random;

    public class CompareSorting {

        // Optimized Bubble Sort Implementation
        public static void bubbleSort(int[] arr) {
            int n = arr.length;
            boolean swapped;
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                // Last i elements are already sorted, no need to check them
                for (int j = 0; j < n - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // Swap the elements
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swapped = true;
                    }
                }
                // If no two elements were swapped by inner loop, the array is sorted
                if (!swapped) {
                    break;
                }
            }
        }

        // Merge Sort Implementation
        public static void mergeSort(int[] arr) {
            if (arr.length < 2) return;
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(left);
            mergeSort(right);

            merge(arr, left, right);
        }

        private static void merge(int[] arr, int[] left, int[] right) {
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                }
            }

            while (i < left.length) {
                arr[k++] = left[i++];
            }

            while (j < right.length) {
                arr[k++] = right[j++];
            }
        }

        // Quick Sort Implementation
        public static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }

        private static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            return i + 1;
        }

        // Utility function to generate random data
        public static int[] generateRandomData(int size) {
            int[] data = new int[size];
            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                data[i] = rand.nextInt(1000000); // Generate random numbers up to 1,000,000
            }
            return data;
        }

        // Function to measure the time taken by sorting algorithms
        public static void compareSortingPerformance(int[] data) {
            int[] dataCopy = Arrays.copyOf(data, data.length);

            long startTime = System.nanoTime();
            bubbleSort(dataCopy);
            long bubbleSortTimeNs = System.nanoTime() - startTime;
            double bubbleSortTimeMs = bubbleSortTimeNs / 1_000_000.0;

            dataCopy = Arrays.copyOf(data, data.length);
            startTime = System.nanoTime();
            mergeSort(dataCopy);
            long mergeSortTimeNs = System.nanoTime() - startTime;
            double mergeSortTimeMs = mergeSortTimeNs / 1_000_000.0;

            dataCopy = Arrays.copyOf(data, data.length);
            startTime = System.nanoTime();
            quickSort(dataCopy, 0, dataCopy.length - 1);
            long quickSortTimeNs = System.nanoTime() - startTime;
            double quickSortTimeMs = quickSortTimeNs / 1_000_000.0;

            System.out.println("Bubble Sort Time (ms): " + bubbleSortTimeMs);
            System.out.println("Merge Sort Time (ms): " + mergeSortTimeMs);
            System.out.println("Quick Sort Time (ms): " + quickSortTimeMs);
        }

        public static void main(String[] args) {
            int[] sizes = {1000, 10000, 1000000};

            for (int size : sizes) {
                int[] data = generateRandomData(size);
                System.out.println("\nDataset Size: " + size);
                compareSortingPerformance(data);
            }
        }
    }
