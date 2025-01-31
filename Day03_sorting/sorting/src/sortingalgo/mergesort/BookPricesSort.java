package sortingalgo.mergesort;

import java.util.Scanner;

public class BookPricesSort {

    // Mergesort function
    public static void mergeSort(int[] price, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(price, left, mid);
            mergeSort(price, mid + 1, right);
            merge(price, left, mid, right);
        }
    }

    // Merge function
    public static void merge(int[] price, int left, int mid, int right) {
        int n = mid - left + 1;
        int n1 = right - mid;

        int[] arr = new int[n];
        int[] arr1 = new int[n1];

        System.arraycopy(price, left, arr, 0, n);
        System.arraycopy(price, mid + 1, arr1, 0, n1);

        int i = 0, j = 0, k = left;

        while (i < n && j < n1) {
            if (arr[i] <= arr1[j]) {
                price[k++] = arr[i++];
            } else {
                price[k++] = arr1[j++];
            }
        }

        // Fill remaining elements
        while (i < n) {
            price[k++] = arr[i++];
        }
        while (j < n1) {
            price[k++] = arr1[j++];
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter number of book prices:");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] price = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter price " + (i + 1));
            price[i] = sc.nextInt();
        }

        System.out.println("Prices before sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(price[i] + " ");
        }
        System.out.println();

        mergeSort(price, 0, n - 1);

        System.out.println("Prices after sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(price[i] + " ");
        }
        System.out.println();
    }
}
