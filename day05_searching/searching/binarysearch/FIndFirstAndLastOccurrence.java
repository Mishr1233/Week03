package org.example.searching.binarysearch;

public class FIndFirstAndLastOccurrence{

    public static int[] findFirstAndLast(int[] arr, int target) {
        int[] result = {-1, -1};

        // Find the first occurrence of the target
        result[0] = findFirst(arr, target);
        if (result[0] == -1) {
            return result; // If target is not found, return {-1, -1}
        }

        // Find the last occurrence of the target
        result[1] = findLast(arr, target);

        return result;
    }

    // Helper method to find the first occurrence
    private static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int first = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return first;
    }

    // Helper method to find the last occurrence
    private static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int last = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                last = mid;  // Found the target, but continue to search on the right side
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return last;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5, 6};
        int target = 2;

        int[] result = findFirstAndLast(arr, target);

        System.out.println("First occurrence: " + result[0]);
        System.out.println("Last occurrence: " + result[1]);
    }
}
