// LeetCode 694: Number of Distinct Islands
// https://leetcode.com/problems/number-of-distinct-islands/

// Algorithm: Similar to Number of Islands, except we build a string in our DFS to represent the path we took to sink the island
// If we come across an island that is structurally the same, we'll compute the same path and know not to add it

// Time Complexity: O(m * n) because we must iterate over every element in our grid
// Space Complexity: O(m * n) because our recursion depth could potentially be m * n if all the values in the grid is equal to 1
public class NumberOfDistinctIslands {
    // X = start
    // O = out of bounds OR water
    // U = up
    // R = right
    // D = down
    // L = left
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        Set<String> islandSet = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] = 1) {
                    String islandString = computeIslandString(grid, i, j, "X");
                    islandSet.add(islandString);
                }
            }
        }

        return islandSet.size();
    }

    public String computeIslandString(int[][] grid, int i, int j, String direction) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return "O";
        }

        grid[i][j] = 0;

        String left = computeIslandString(grid, i, j - 1, "L");
        String right = computeIslandString(grid, i, j + 1, "R");
        String up = computeIslandString(grid, i - 1, j, "U");
        String down = computeIslandString(grid, i + 1, j, "D");
        
        return direction + left + right + up + down;
    }
}
