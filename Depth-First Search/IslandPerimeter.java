// LeetCode 463: Island Perimeter
// https://leetcode.com/problems/island-perimeter/

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // Whenever we come across a 1, check the borders around the cell to determine the perimeter of that cell
                // Then add to our final perimeter result
                if (grid[i][j] == 1) {
                    perimeter += getPerimeter(grid, i, j);
                }
            }
        }
        
        return perimeter;
    }
    
    // This function does not implement a traditional DFS
    // All it does is check the borders of the current cell and increment the count accordingly
    public int getPerimeter(int[][] grid, int i, int j) {
        int count = 0;
        
        if (i - 1 < 0 || grid[i - 1][j] == 0) {
            count++;
        }
        
        if (i + 1 >= grid.length || grid[i + 1][j] == 0) {
            count++;
        }
        
        if (j - 1 < 0 || grid[i][j - 1] == 0) {
            count++;
        }
        
        if (j + 1 >= grid[0].length || grid[i][j + 1] == 0) {
            count++;
        }
        
        return count;
    }
}
