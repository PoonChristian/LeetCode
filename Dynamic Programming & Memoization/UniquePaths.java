// LeetCode 62: Unique Paths
// https://leetcode.com/problems/unique-paths/
// Top Down and Bottom Up Solutions

public class UniquePaths {
    private int uniquePathsRecursive(int[][] memo, int i, int j) {
        if (i == memo.length - 1 && j == memo[i].length - 1) {
            return 1;
        } else if (i < 0 || i >= memo.length || j < 0 || j >= memo[i].length) {
            return 0;
        } else if (memo[i][j] != 0) {
            return memo[i][j];
        } else {
            memo[i][j] = uniquePathsRecursive(memo, i + 1, j) + uniquePathsRecursive(memo, i, j + 1);
            return memo[i][j];
        }
    }
    
    public int uniquePathsTopDown(int m, int n) {
        int[][] memo = new int[m][n];
        return uniquePathsRecursive(memo, 0, 0);
    }

    public int uniquePathsBottomUp(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
}
