package sortingalgo.heapsort;

import java.util.Scanner;

public class ApplicantsBysalary {

    // Function to perform heap sort
    public static void heapSort(int[] salary) {
        int n = salary.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salary, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap current root (largest) with the last element
            int temp = salary[0];
            salary[0] = salary[i];
            salary[i] = temp;

            // Call heapify on the reduced heap
            heapify(salary, i, 0);
        }
    }

    // Function to heapify a subtree rooted at index i
    public static void heapify(int[] salary, int n, int i) {
        int largest = i;  // Initialize largest as root
        int left = 2 * i + 1;  // left child
        int right = 2 * i + 2;  // right child

        // If left child is larger than root
        if (left < n && salary[left] > salary[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && salary[right] > salary[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int temp = salary[i];
            salary[i] = salary[largest];
            salary[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(salary, n, largest);
        }
    }

    public static void main(String[] args) {
        // Taking input from the user
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of job applicants:");
        int n = sc.nextInt();
        int[] salary = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter expected salary for applicant " + (i + 1) + ":");
            salary[i] = sc.nextInt();
        }

        // Display salaries before sorting
        System.out.println("Salaries before sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(salary[i] + " ");
        }
        System.out.println();

        // Perform heap sort
        heapSort(salary);

        // Display salaries after sorting
        System.out.println("Salaries after sorting in ascending order:");
        for (int i = 0; i < n; i++) {
            System.out.print(salary[i] + " ");
        }
        System.out.println();
    }
}
