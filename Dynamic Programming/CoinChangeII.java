// LeetCode 518: Coin Change 2
// https://leetcode.com/problems/coin-change-2/
// Bottom Up and Top Down Solutions

public class CoinChangeII {
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

    public int topDown(int amount, int[] coins) {
        return changeRecursive(coins, 0, amount, new Integer[coins.length][amount + 1]);
    }

    public int bottomUp(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                int currentCoin = coins[i - 1];
                int withoutCoin = dp[i - 1][j];
                int withCoin = j >= currentCoin ? dp[i][j - currentCoin] : 0;
                dp[i][j] = withoutCoin + withCoin;
            }
        }

        return dp[coins.length][amount];
    }
}
