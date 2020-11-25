// 0/1 Knapsack Problem
// Popular DP Problem not included on LeetCode
// Top Down and Bottom Up Solutions

public class ZeroOneKnapsack {
    private int ZeroOneKnapsackRecursive(int[] weights, int[] values, int itemIndex, int remainingWeight, int[][] memo) {
        if (itemIndex < 0 || remainingWeight <= 0) {
            return 0;
        }

        if (memo[itemIndex][remainingWeight] != 0) {
            return memo[itemIndex][remainingWeight];
        }

        int taken = 0;
        if (remainingWeight >= weights[itemIndex]) {
            taken = values[itemIndex] + ZeroOneKnapsackRecursive(weights, values, itemIndex - 1, remainingWeight - weights[itemIndex], memo);
        }

        int notTaken = ZeroOneKnapsackRecursive(weights, values, itemIndex - 1, remainingWeight, memo);

        memo[itemIndex][remainingWeight] = Math.max(taken, notTaken);
        return memo[itemIndex][remainingWeight];
    }

    public int ZeroOneKnapsackTopDown(int weightLimit, int[] weights, int[] values) {
        int[][] memo = new int[weights.length][weightLimit + 1];
        return ZeroOneKnapsackRecursive(weights, values, weights.length - 1, weightLimit, memo);
    }

    public int ZeroOneKnapsackBottomUp(int weightLimit, int[] weights, int[] values) {
        int[][] dp = new int[weights.length + 1][weightLimit + 1];

        for (int i = 1; i <= weights.length; i++) {
            for (int w = 1; w <= weightLimit; w++) {
                if (w >= weights[i - 1]) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[weights.length][weightLimit];
    }
}