// LeetCode 486: Predict the Winner
// https://leetcode.com/problems/predict-the-winner/
// Bottom Up and Top Down Solutions

public class PredictTheWinner {
    private int findWinner(int[] nums, int[][] memo, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        if (memo[start][end] != 0) {
            return memo[start][end];
        }

        int a = nums[start] - findWinner(nums, memo, start + 1, end);
        int b = nums[end] - findWinner(nums, memo, start, end - 1);

        memo[start][end] = Math.max(a, b);

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
