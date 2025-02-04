package org.example.searching.binarysearch;


public class PeakElement {

    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is a peak element
            if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                return mid;
            }

            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            }
            // If the right neighbor is greater, search the right half
            else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 0, 1, 50,79,7};
        int peakIndex = findPeakElement(arr);
        System.out.println("Peak element index: " + peakIndex + ", Value: " + arr[peakIndex]);
    }
}

