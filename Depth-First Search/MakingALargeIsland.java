// LeetCode 827: Making A Large Island
// https://leetcode.com/problems/making-a-large-island/

/*
  Algorithm (4 Steps):
    1. Iterate over the matrix and for every 1 we come across, calculate the size of the island and update the values from 1 to a unique islandId
    2. Update maxSize if the current island we FOUND is greater than the current maxSize
    3. Iterate over the matrix again and for every 0 we come across, look for the sizes of unique adjacent islands (using a HashMap), and add those sizes + 1
    4. Update maxSize if the island we MADE is greater than the current maxSize
*/
public class MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int maxSize = 0;
        Map<Integer, Integer> islandSizes = new HashMap<Integer, Integer>();
        int islandId = 2;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int size = getIslandSize(grid, i, j, islandId);
                    islandSizes.put(islandId++, size);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> visitedIslands = new HashSet<Integer>();
                    
                    int top = getAdjacentIslandSize(grid, i - 1, j, islandSizes, visitedIslands);
                    int right = getAdjacentIslandSize(grid, i, j + 1, islandSizes, visitedIslands);
                    int bottom = getAdjacentIslandSize(grid, i + 1, j, islandSizes, visitedIslands);
                    int left = getAdjacentIslandSize(grid, i, j - 1, islandSizes, visitedIslands);
                    
                    maxSize = Math.max(maxSize, 1 + top + right + bottom + left);
                }
            }
        }
        
        return maxSize;
    }
    
    public int getIslandSize(int[][] grid, int i, int j, int islandId) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 1) {
            return 0;
        }
        
        grid[i][j] = islandId;
        
        int top = getIslandSize(grid, i - 1, j, islandId);
        int right = getIslandSize(grid, i, j + 1, islandId);
        int bottom = getIslandSize(grid, i + 1, j, islandId);
        int left = getIslandSize(grid, i, j - 1, islandId);
        
        return 1 + top + right + bottom + left;
    }
    
    public int getAdjacentIslandSize(int[][] grid, int i, int j, Map<Integer, Integer> islandSizes, Set<Integer> visitedIslands) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] < 2 || visitedIslands.contains(grid[i][j])) {
            return 0;
        }
        
        visitedIslands.add(grid[i][j]);
        
        return islandSizes.get(grid[i][j]);
    }
}