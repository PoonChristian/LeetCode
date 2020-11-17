// LeetCode 746: Min Cost Climbing Stairs
// https://leetcode.com/problems/min-cost-climbing-stairs/
// Top Down and Bottom Up Solutions

public class MinCostClimbingStairs {
    private int findMinCost(int[] cost, int[] memo, int index) {
        if (index < 0) {
            return 0;
        } else if (index == 0 || index == 1) {
            return cost[index];
        } else if (memo[index] != 0) {
            return memo[index];
        } else {
            int first = findMinCost(cost, memo, index - 1);
            int second = findMinCost(cost, memo, index - 2);
            memo[index] = cost[index] + Math.min(first, second);
            return memo[index];
        }
    }

    public int minCostClimbingStairsTopDown(int[] cost) {
        int[] memo = new int[cost.length];
        return Math.min(findMinCost(cost, memo, cost.length - 1), findMinCost(cost, memo, cost.length - 2));
    }

    public int minCostClimbingStairsBottomUp(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public int minCostClimbingStairsBottomUpOptimizedSpace(int[] cost) {
        int first = cost[0];
        int second = cost[1];
        
        for (int i = 2; i < cost.length; i++) {
            int current = cost[i] + Math.min(first, second);
            first = second;
            second = current;
        }
        
        return Math.min(first, second);
    }
}
