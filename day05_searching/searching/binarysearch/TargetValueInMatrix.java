package org.example.searching.binarysearch;

public class TargetValueInMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0)
            return false;
        int cols = matrix[0].length;

        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Convert mid to row and column indices
            int midRow = mid / cols;
            int midCol = mid % cols;

            // Get the middle element
            int midValue = matrix[midRow][midCol];

            // Compare with the target
            if (midValue == target) {
                return true; // Found the target
            } else if (midValue < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return false; // Element not found
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        int target = 5;
        boolean result = searchMatrix(matrix, target);
        System.out.println("Target found: " + result); // Output: Target found: true
    }
}
