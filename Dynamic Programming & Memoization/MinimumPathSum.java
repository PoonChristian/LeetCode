// LeetCode 64: Minimum Path Sum
// https://leetcode.com/problems/minimum-path-sum/
// Bottom Up and Top Down Solutions

public class MinimumPathSum {
    private int minPathSumRecursive(int[][] grid, int[][] memo, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        } else if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return Integer.MAX_VALUE;
        } else if (memo[i][j] != 0) {
            return memo[i][j];
        } else {
            memo[i][j] = Math.min(minPathSumRecursive(grid, memo, i + 1, j), minPathSumRecursive(grid, memo, i, j + 1)) + grid[i][j];
            return memo[i][j];
        }
    }

    public int minPathSumTopDown(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return minPathSumRecursive(grid, memo, 0, 0);
    }

    public int minPathSumBottomUp(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = grid[i][j];
                if (i > 0 && j > 0) {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
}