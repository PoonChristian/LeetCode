// LeetCode 849: Maximize Distance to Closest Person
// https://leetcode.com/problems/maximize-distance-to-closest-person/

// Algorithm: Use two arrays, 1 to keep track of the closest person seated to the left, and 1 to keep track of the closest person seated to the right
//      To get the closest person at an empty seat, take the minimum of a position at left and right and check if it ever surpasses the maximum distance
public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        // Extract seats.length to n
        int n = seats.length;

        // Initialize left and right arrays and fill them with n
        // We fill it to account for edge cases when calculating the minimum distance between left and right
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, n);
        Arrays.fill(right, n);
        
        // Iterate from left to right to fill the left array
        for (int i = 0; i < n; i++) {
            // If someone is sitting at i, then set left[i] equal to 0
            if (seats[i] == 1) {
                left[i] = 0;
            } else if (i > 0) {
                // Otherwise if i is greater than 0, then check the seat to the left (i - 1) and add 1 to increase the distance
                left[i] = left[i - 1] + 1;
            }
        }
        
        // Iterate from right to left to fill the right array
        for (int i = n - 1; i >= 0; i--) {
            // If someone is sitting at i, then set right[i] equal to 0
            if (seats[i] == 1) {
                right[i] = 0;
            } else if (i < n - 1) {
                // Otherwise if i is less than n - 1, then check the seat to the right (i + 1) and add 1 to increase the distance
                right[i] = right[i + 1] + 1;
            }
        }
        
        // Initialize the result variable
        int maxDist = 0;
        
        for (int i = 0; i < n; i++) {
            // If we come across an empty seat, we need to calculate the distance to the closest person by taking the min between left[i] and right[i]
            // If the distance to the closest person surpasses maxDist, then update it
            if (seats[i] == 0) {
                maxDist = Math.max(maxDist, Math.min(left[i], right[i]));
            }
        }
        
        // Return maxDist
        return maxDist;
    }
}
