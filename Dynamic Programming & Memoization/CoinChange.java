// LeetCode 322: Coin Change
// https://leetcode.com/problems/coin-change/
// Bottom Up and Top Down Solutions

public class CoinChange {
    private int changeRecursive(int[] coins, int remaining, int[] dp) {
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

    public int topDown(int[] coins, int amount) {
        return coinChangeRecursive(coins, amount, new int[amount]);
    }

    public int bottomUp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        Arrays.sort(coins);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin > i) {
                    break;
                } else {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
