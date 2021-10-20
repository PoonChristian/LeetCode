// LeetCode 152: Maximum Product Subarray
// https://leetcode.com/problems/maximum-product-subarray/

// Algorithm: Very similar to MaximumSubarray, except we also need to keep track of the current min since a negative times another negative equals a positive
// MaximumSubarray: https://leetcode.com/problems/maximum-subarray/
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        // Similar to Maximum Subarray, store a globalMax variable starting at the 0th index of the input array
        int globalMax = nums[0];
        
        // Keep track of two variables, the min and max, throughout the iterations.
        int currMin = nums[0];
        int currMax = nums[0];
        
        // Iterate over all the elements starting from index 1
        for (int i = 1; i < nums.length; i++) {
            // Store a temp variable for the currMax since we'll be updating it in the process
            int temp = currMax;
            
            /*
                Calculate the current max by grabbing the max from these 3 values
                    1. currMax * nums[i]
                    2. currMin * nums[i]
                    3. nums[i]
                The reason we want to compare all 3 values is because: (negative * negative = positive) and we don't know which can turn out to be the max, so we want to take a greedy approach
            */
            currMax = Math.max(Math.max(currMax * nums[i], currMin * nums[i]), nums[i]);
            
            // Do the same calculation for the current min
            // Use temp because it contains the original value for current max before it got updated in the previous line
            currMin = Math.min(Math.min(temp * nums[i], currMin * nums[i]), nums[i]);
            
            // Update the global max with the greater max value
            globalMax = Math.max(globalMax, currMax);
        }
        
        // Return the global max
        return globalMax;
    }
}