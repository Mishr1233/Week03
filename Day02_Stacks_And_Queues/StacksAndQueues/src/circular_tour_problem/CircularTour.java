package circular_tour_problem;



import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {

    // Function to find the starting point for completing the circular tour
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;

        // Variables to track total and current surplus petrol
        int totalSurplus = 0;
        int currentSurplus = 0;

        // Variable to store the start point of the circular tour
        int start = 0;

        // Queue to simulate the tour and track surplus petrol
        Queue<Integer> queue = new LinkedList<>();

        // Iterate over the petrol pumps
        for (int i = 0; i < n; i++) {
            int surplus = petrol[i] - distance[i];
            totalSurplus += surplus;
            currentSurplus += surplus;

            // Add the current pump to the queue
            queue.offer(i);

            // If the current surplus becomes negative, reset the tour start
            if (currentSurplus < 0) {
                // Reset start to the next pump and clear the queue
                start = i + 1;
                currentSurplus = 0;
                queue.clear();
            }
        }

        // If totalSurplus is non-negative, we can complete the tour
        return totalSurplus >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        // Sample input: petrol and distance arrays
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        // Find the starting point for the circular tour
        int start = findStartingPoint(petrol, distance);

        if (start == -1) {
            System.out.println("Tour is not possible.");
        } else {
            System.out.println("Start at pump: " + start);
        }
    }
}
