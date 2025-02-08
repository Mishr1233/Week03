package org.example.timeandpacecomlexity;

public class RecursiveIterativeFibonacciComputation {

    // Iterative Fibonacci Computation
    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // Recursive Fibonacci Computation
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Compare Function
    public static void compareFibonacciMethods(int n) {
        double startTime, recursiveTime, iterativeTime;

        // Measure Iterative Fibonacci time
        startTime = System.currentTimeMillis();
        fibonacciIterative(n);
        iterativeTime = System.currentTimeMillis() - startTime;

        // Measure Recursive Fibonacci time
        startTime = System.currentTimeMillis();
        try {
            fibonacciRecursive(n);
        } catch (StackOverflowError e) {
            System.out.println("Recursive approach failed for n=" + n + " due to StackOverflowError.");
            return;
        }
        recursiveTime = System.currentTimeMillis() - startTime;

        // Output the results
        System.out.println("\nFibonacci time comparison for n=" + n);
        System.out.println("Iterative Fibonacci time: " + iterativeTime + " ms");
        System.out.println("Recursive Fibonacci time: " + recursiveTime + " ms");
    }

    public static void main(String[] args) {
        int[] testValues = {10, 30, 50};
        //compare all dataSet
        for (int n : testValues) {
            compareFibonacciMethods(n);
        }
    }
}
