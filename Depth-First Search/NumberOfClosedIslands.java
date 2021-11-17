// LeetCode 1254: Number of Closed Islands
// https://leetcode.com/problems/number-of-closed-islands/

// Time Complexity: O(m * n) where m is the number of rows and n is the number of columns
//          Reason: We must iterate through every element in the input matrix
// Space Complexity: O(m * n) where m is the number of rows and n is the number of columns
//           Reason: In the worst case, the input matrix will have all 0's
public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int closedIslands = 0;
        
        // This problem boils down to the fact that an island can only be closed if it's surrounded by water (cells with value 1)
        // This means that an island on the edge of the grid cannot be closed, so we don't want to consider edge cells in our dfs
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                // Check if grid[i][j] is 0 (land), and then dfs from this coordinate to see if our island is closed
                if (grid[i][j] == 0 && isClosedIsland(grid, i, j)) {
                    closedIslands++;
                }
            }
        }
        
        return closedIslands;
    }
    
    public boolean isClosedIsland(int[][] grid, int i, int j) {
        // Base Case 1: We go out of the grid's bounds, meaning this island is definitely not closed. Return false
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return false;
        }
        
        // Base Case 2: We hit water within the grid, meaning water surrounds this part of the island. Return true
        if (grid[i][j] == 1) {
            return true;
        }
        
        // Set grid[i][j] equal to 1 to mark it as visited
        grid[i][j] = 1;
        
        // dfs all vertical and horizontal directions
        boolean up = isClosedIsland(grid, i - 1, j);
        boolean down = isClosedIsland(grid, i + 1, j);
        boolean left = isClosedIsland(grid, i, j - 1);
        boolean right = isClosedIsland(grid, i, j + 1);
        
        // We want to return whether or not ALL these directions lead to base case 2, so && them all and return
        return up && down && left && right;
    }
}
