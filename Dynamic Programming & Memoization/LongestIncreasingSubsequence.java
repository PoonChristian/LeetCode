// LeetCode 300: Longest Increasing Subsequence
// https://leetcode.com/problems/longest-increasing-subsequence/
// Top Down and Bottom Up Solutions

public class LongestIncreasingSubsequence {
    // Note: We use prevIndex + 1 throughout this function because it starts out at -1 to denote no previous element in the first call
    private int lengthOfLISRecursive(int[] nums, int[][] memo, int prevIndex, int currIndex) {
        // Base Case: If the index goes out of bounds, return 0
        if (currIndex == nums.length) {
            return 0;
        }
        
        // Return the value of this subproblem if we've already computed it
        if (memo[prevIndex + 1][currIndex] != 0) {
            return memo[prevIndex + 1][currIndex];
        }

        // Simulate taking the element (adding 1) and including it in our LIS if it's greater than the previous element
        // In the first call, we won't have a previous element, so we can go ahead and include the current element in the beginning
        int taken = 0;
        if (prevIndex < 0 || nums[currIndex] > nums[prevIndex]) {
            taken = 1 + lengthOfLISRecursive(nums, memo, currIndex, currIndex + 1);
        }
        
        // Simulate not taking the element and compute the LIS without the current element
        int notTaken = lengthOfLISRecursive(nums, memo, prevIndex, currIndex + 1);
        
        // Store the value of this subproblem and return it
        memo[prevIndex + 1][currIndex] = Math.max(taken, notTaken);
        return memo[prevIndex + 1][currIndex];
    }

    public int lengthOfLISTopDown(int[] nums) {
        // Initialize memo array to store the value of overlapping subproblems
        int[][] memo = new int[nums.length][nums.length];

        // Return the min distance at the last row and last column of the matrix
        return lengthOfLISRecursive(nums, memo, -1, 0);
    }

    public int lengthOfLISBottomUp(int[] nums) {
        // Quick check to see if there are elements in the array, if not then immediately return 0
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // Initialize dp array with same length as nums
        int[] dp = new int[nums.length];

        // Store a maxLength variable to ensure we find the max length LIS within the nums array
        // Note: We can't just return dp[nums.length - 1] because it's possible our LIS can end in the middle of the array
        int maxLength = 1;
        
        // Iterate through the entire nums array
        for (int i = 0; i < nums.length; i++) {
            // Every subproblem starts with an LIS of 1 (array of length 1 = LIS of length of 1)
            dp[i] = 1;
            
            // Iterate from the beginning of the array to i
            // If the value at j is less than the value at i, then we take the maximum between dp[i] and dp[j] + 1
            // Reason: It's either we already have a better LIS or we add this element to our current LIS
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            // Recompute maxLength to make sure we have always have the best LIS
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        // Return the maxLength representing the best LIS in our nums array
        return maxLength;
    }
}
