// LeetCode 200: Number of Islands
// https://leetcode.com/problems/number-of-islands/

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int result = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                result += dfs(grid, i, j);
            }
        }
        
        return result;
    }

    public int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return 0;
        }
        
        grid[i][j] = '0';
        
        dfs(grid, i - 1, j); 
        dfs(grid, i, j + 1); 
        dfs(grid, i + 1, j); 
        dfs(grid, i, j - 1);
        
        return 1;
    }
}
