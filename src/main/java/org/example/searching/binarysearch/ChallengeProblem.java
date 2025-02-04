package org.example.searching.binarysearch;

import java.util.Arrays;

public class ChallengeProblem  {

    // Function to find the first missing positive integer using Linear Search
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] > 0 && nums[i] <= n) {
                int index = nums[i] - 1;
                if (nums[index] > 0) {
                    nums[index] = -nums[index];  // Negate the value at that index
                }
            }
        }

        // Find the first positive integer which is not marked
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;  // Return the first missing positive number
            }
        }

        return n + 1;
    }

    // Function to perform Binary Search to find the index of the target number
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;  // Target found at mid
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;  // Search in the left half
            }
        }

        return -1;  // Target not found
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};

        // Find the first missing positive integer using Linear Search
        int firstMissing = firstMissingPositive(nums);
        System.out.println("First Missing Positive Integer: " + firstMissing);

        // Now use Binary Search to find the index of a target number
        Arrays.sort(nums);
        int target = 4;
        int targetIndex = binarySearch(nums, target);

        System.out.println("Index of target " + target + ": " + targetIndex);
    }
}
