// LeetCode 70: Climbing Stairs
// https://leetcode.com/problems/climbing-stairs/
// Top Down and Bottom Up Solutions

public class ClimbingStairs {
    private int findWays(int[] memo, int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 0 || n == 1) {
            return 1;
        }
        
        if (memo[n] != 0) {
            return memo[n];
        }
        
        memo[n] = findWays(memo, n - 1) + findWays(memo, n - 2);
        
        return memo[n];
    }

    public int climbStairsTopDown(int n) {
        int[] memo = new int[n + 1];
        return findWays(memo, n);
    }

    public int climbStairsBottomUp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int climbStairsBottomUpOptimizedSpace(int n) {
        int first = 1;
        int second = 1;

        for (int i = 2; i <= n; i++) {
            int curr = first + second;
            first = second;
            second = curr;
        }

        return second;
    }
}
