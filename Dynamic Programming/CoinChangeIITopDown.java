// LeetCode 518: Coin Change 2
// https://leetcode.com/problems/coin-change-2/
// Bottom Up Approach

public class CoinChangeIITopDown {
    public int change(int amount, int[] coins) {
        return changeRecursive(coins, 0, amount, new Integer[coins.length][amount + 1]);
    }

    private int changeRecursive(int[] coins, int coinIndex, int remaining, Integer[][] dp) {
        if (remaining == 0) {
            return 1;
        }

        if (remaining < 0 || coinIndex == coins.length) {
            return 0;
        }

        if (dp[coinIndex][remaining - 1] != null) {
            return dp[coinIndex][remaining - 1];
        }

        int withoutCoin = changeRecursive(coins, coinIndex + 1, remaining, dp);
        int withCoin = changeRecursive(coins, coinIndex, remaining - coins[coinIndex], dp);

        dp[coinIndex][remaining - 1] = withoutCoin + withCoin;
        return dp[coinIndex][remaining - 1];
    }
}
