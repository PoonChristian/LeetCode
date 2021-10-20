// LeetCode 42: Trapping Rain Water
// https://leetcode.com/problems/trapping-rain-water/

/*
Algorithm:
    1. Find the maximum to the left of an index and to the right of an index
    2. Take the minimum between the leftMax and rightMax
        - Reason: Water will overflow if we take the maximum so we need the minimum
    3. Add to a running count at each index using the following formula:
        - amount += min(leftMax, rightMax) - current height

Optimizations (Two Methods):
    1. Use dynamic programming to store the leftMaxes and rightMaxes in arrays so we don't recompute values within the main loop
        - Time Complexity: O(n) since we iterate 3n times
        - Space Complexity: O(n) for storing extra arrays
    2. Use the two-pointer lower envelope approach to find the appropriate minimum between the left and right maxes
        - The leftMax and rightMax are monotonic
            - LeftMax will always increase or stay the same toward the right /
            - RightMax will always increase or stay the same toward to the right \
        - Knowing the fact above, we can calculate the lower envelope (the minimum between the left max and right max)
            - Apply the same formula:  amount += min(leftMax, rightMax) - current height
            - Move our leftPtr forward if leftMax is smaller or equal, move our rightPtr backward if rightMax is smaller
                - Reason: G(i) = min(max(H[0...i]), max(H[i...n - 1])) for i = 0,1,2,3...,n - 1
                - If we can determine G(i) with certainty, then we can increment/decrement the pointer accordingly
                - See this video for more information: https://youtu.be/XqTBrQYYUcc?t=375
        - Time Complexity: O(n) since we iterate our left and right pointers towards the middle only once
        - Space Complexity: O(1) since we only use two pointers

*/
public class TrappingRainWater {
    public int trapWithDP(int[] height) {
        // We can't trap any water if the height array is 0
        if (height == null || height.length == 0) {
            return 0;
        }
        
        // Extract the length of the height array
        int n = height.length;
        
        // Initialize an array that stores the max value to the left of a particular index
        int[] leftMaxes = new int[n];

        // The max of the first element is itself
        leftMaxes[0] = height[0];

        // leftMaxes[i] is equal to max(height[0], height[1],..., height[i])
        for (int i = 1; i < n; i++) {
            leftMaxes[i] = Math.max(leftMaxes[i - 1], height[i]);
        }
        
        // Initialize an array that stores the max value to the left of a particular index
        int[] rightMaxes = new int[n];

        // The max of the n - 1 element is itself
        rightMaxes[n - 1] = height[n - 1];

        // rightMaxes[i] is equal to max(height[i], height[i + 1],..., height[n - 1])
        for (int i = n - 2; i >= 0; i--) {
            rightMaxes[i] = Math.max(rightMaxes[i + 1], height[i]);
        }
        
        // Initialize an amount variable to store the amount of water that can be trapped
        int amount = 0;

        // Iterate through all elements in the array
        for (int i = 0; i < n; i++) {
            // Get the minimum height between the maxes to the left and to the right of the current element
            int minHeight = Math.min(leftMaxes[i], rightMaxes[i]);

            // Increment the amount by the minHeight - the current height in order to account for water that can be held at the current element
            amount += minHeight - height[i];
        }
        
        return amount;
    }

    public int trapWithTwoPointerLowerEnvelope(int[] height) {
        // Extract the length of the height array
        int n = height.length;
        
        // We can't trap any water if there are less than 3 elements in the array
        if (n < 3) {
            return 0;
        }
        
        // Initialize two pointers i and j
        int i = 0;
        int j = n - 1;

        // Initialize a running leftMax and rightMax
        int leftMax = height[i];
        int rightMax = height[j];

        // Initialize the amount variable to store the result
        int amount = 0;
        
        // Iterate until i and j meet (inclusive in order to consider the element in the middle)
        while (i <= j) {
            // Update our left and rightMax at each iteration
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);

            // If leftMax is less than or equal to rightMax, then add leftMax - height[i] to our amount
            //      Move i forward since we know for sure i is where the minimum height lies at this current iteration
            // Otherwise, add rightMax - height[j] to our amount
            //      Move j backward since we know for sure j is where the minimum height lies at this current iteration
            if (leftMax <= rightMax) {
                amount += leftMax - height[i++];
            } else {
                amount += rightMax - height[j--];
            }
        }
        
        // Return the amount
        return amount;
    }
}
