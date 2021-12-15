// LeetCode 486: Predict the Winner
// https://leetcode.com/problems/predict-the-winner/
// Top Down and Bottom Up Solutions

public class PredictTheWinner {
    private int findWinner(int[] nums, int[][] memo, int start, int end) {
        // If start reaches the end, then just return the number at that index
        if (start == end) {
            return nums[start];
        }

        // If the answer for the subarray from start to end has already been computed, then return it
        if (memo[start][end] != 0) {
            return memo[start][end];
        }

        // a represents the score if the player picks the left value
        // In the recursive call, increment start by 1 since we used nums[start], then subtract it from nums[start]
        /* 
        Why subtract?
            Because player1 and player2 are competing against each other
            Once player1 takes nums[start], then we want to subtract the most optimal score player2 can get
            after player1 makes this decision because the scores offset each other through subtraction.
            This is because the answer to the recursive call could be either positive (player1 wins) or negative (player2 wins)
            Same logic applies for when player2 takes nums[start].
            If a is zero or positive, then we know player1 won for the current subarray. However if a is negative, then we know player2 won
        */
        int a = nums[start] - findWinner(nums, memo, start + 1, end);

        // b represents the score if the player picks the right value
        // In the recursive call, decrement end by 1 since we used nums[end], then subtract it from nums[end]
        // See above explanation for why we use subtraction
        int b = nums[end] - findWinner(nums, memo, start, end - 1);

        // Store the result of the subarray from start to end into memo. We want the max in order to get the highest score that a player can get for this subarray
        memo[start][end] = Math.max(a, b);

        // Return the result
        return memo[start][end];
    }

    public boolean PredictTheWinnerTopDown(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        return findWinner(nums, memo, 0, nums.length - 1) >= 0;
    }

    public boolean PredictTheWinnerBottomUp(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        for (int start = nums.length - 1; start >= 0; start--) {
            dp[start][start] = nums[start];
            for (int end = start + 1; end < nums.length; end++) {
                int a = nums[start] - dp[start + 1][end];
                int b = nums[end] - dp[start][end - 1];
                dp[start][end] = Math.max(a, b);
            }
        }

        return dp[0][nums.length - 1] >= 0;
    }

    public boolean PredictTheWinnerBottomUpOptimizedSpace(int[] nums) {
        int[] dp = new int[nums.length];

        for (int start = nums.length - 1; start >= 0; start--) {
            dp[start] = nums[start];
            for (int end = start + 1; end < nums.length; end++) {
                int a = nums[start] - dp[end];
                int b = nums[end] - dp[end - 1];
                dp[end] = Math.max(a, b);
            }
        }

        return dp[nums.length - 1] >= 0;
    }
}
