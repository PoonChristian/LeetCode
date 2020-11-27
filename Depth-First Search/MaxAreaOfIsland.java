// LeetCode 695: Max Area of Island
// https://leetcode.com/problems/max-area-of-island/

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                area = Math.max(area, dfs(grid, i, j));
            }
        }
        
        return area;
    }
    
    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 1) {
            return 0;
        }
        
        grid[i][j] = -1;
        
        return 1 +
            dfs(grid, i - 1, j) + 
            dfs(grid, i, j + 1) + 
            dfs(grid, i + 1, j) + 
            dfs(grid, i, j - 1);
    }
}