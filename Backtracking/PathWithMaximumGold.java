// LeetCode 1219: Path with Maximum Gold
// https://leetcode.com/problems/path-with-maximum-gold/

public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxGold = Math.max(maxGold, backtrack(grid, i, j));
            }
        }
        return maxGold;
    }

    public int backtrack(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }

        int temp = grid[i][j];
        grid[i][j] = 0;

        int up = backtrack(grid, i - 1, j);
        int down = backtrack(grid, i + 1, j);
        int left = backtrack(grid, i, j - 1);
        int right = backtrack(grid, i, j + 1);

        grid[i][j] = temp;
        return Math.max(Math.max(up, down), Math.max(left, right)) + grid[i][j];
    }
}
