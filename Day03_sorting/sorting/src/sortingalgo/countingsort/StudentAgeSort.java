package sortingalgo.countingsort;

import java.util.Scanner;

public class StudentAgeSort {

    // Counting sort method
    public static void countingSort(int[] age, int n) {
        // Find the maximum value in the array
        int max = age[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, age[i]);
        }

        int[] count = new int[max + 1];  // count array size should be max+1

        // Store the count of each element
        for (int i = 0; i < n; i++) {
            count[age[i]]++;
        }

        // Modify the count array to store the cumulative count
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Output array to store sorted values
        int[] output = new int[n];

        // Build the output array by placing each element in its sorted position
        for (int i = n - 1; i >= 0; i--) {
            output[--count[age[i]]] = age[i];
        }

        // Copy the sorted array back into the original array
        System.arraycopy(output, 0, age, 0, n);
    }

    public static void main(String[] args) {
        // Taking input from the user
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of students:");
        int n = sc.nextInt();
        int[] age = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter age of student " + (i + 1) + ":");
            age[i] = sc.nextInt();
        }

        // Display ages before sorting
        System.out.println("Ages before sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(age[i] + " ");
        }
        System.out.println();

        // Perform counting sort
        countingSort(age, n);

        // Display ages after sorting
        System.out.println("Ages after sorting in ascending order:");
        for (int i = 0; i < n; i++) {
            System.out.print(age[i] + " ");
        }
        System.out.println();
    }
}
