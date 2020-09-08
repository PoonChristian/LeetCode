// LeetCode 322: Coin Change
// https://leetcode.com/problems/coin-change/
// Top Down Approach

public class CoinChangeTopDown {
    public int coinChange(int[] coins, int amount) {
        return coinChangeRecursive(coins, amount, new int[amount]);
    }

    private int coinChangeRecursive(int[] coins, int remaining, int[] dp) {
        if (remaining == 0) {
            return 0;
        }

        if (remaining < 0) {
            return -1;
        }

        if (dp[remaining - 1] != 0) {
            return dp[remaining - 1];
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = coinChangeRecursive(coins, remaining - coin, dp);
            if (result >= 0 && result < min) {
                min = 1 + result;
            }
        }

        dp[remaining - 1] = min == Integer.MAX_VALUE ? -1 : min;

        return dp[remaining - 1];
    }
}
