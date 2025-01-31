package sortingalgo.selectionsort;

import java.util.Scanner;

public class ExamScoreSort {

    // Selection sort algorithm
    public static void selectionSort(int[] score, int n) {
        for (int i = 0; i < n - 1; i++) {
            int smallestIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (score[j] < score[smallestIndex]) {
                    smallestIndex = j;
                }
            }

            // Swap the smallest element with the first unsorted element
            int temp = score[i];
            score[i] = score[smallestIndex];
            score[smallestIndex] = temp;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of students:");
        int n = sc.nextInt();
        int[] score = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter score of student " + (i + 1));
            score[i] = sc.nextInt();
        }

        // Display scores before sorting
        System.out.println("Scores before sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(score[i] + " ");
        }
        System.out.println();

        // Perform selection sort
        selectionSort(score, n);

        // Display scores after sorting
        System.out.println("Scores after sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(score[i] + " ");
        }
        System.out.println();
    }
}
