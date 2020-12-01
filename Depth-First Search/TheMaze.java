// LeetCode 490: The Maze
// https://leetcode.com/problems/the-maze/

public class TheMaze {
    // Initialize a directions array {up, down, left, right}
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    // Helper dfs function to check if a path exists
    private boolean dfs(int[][] maze, boolean[][] visited, int[] start, int[] destination) {
        // Base Case: If the start coordinate is equal the destination coordinate, return true
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        
        // Base Case: If this coordinate has already been visited, that means we tried to find a path from here already and it didn't work, so return false
        if (visited[start[0]][start[1]]) {
            return false;
        }
        
        // Mark the current coordinate as true
        visited[start[0]][start[1]] = true;
        
        // Iterate over all directions
        for (int[] direction : directions) {
            // Set our new x and y variables based on the direction we're currently checking
            int x = start[0] + direction[0];
            int y = start[1] + direction[1];
            
            // While the coordinate is in bounds and it is not a wall, then keep going this direction
            while (x >= 0 && x < maze.length && y >= 0 && y < maze[x].length && maze[x][y] == 0) {
                x += direction[0];
                y += direction[1];
            }
            
            // Subtract our current position by the direction we went on because at this point, we're currently sitting on a wall and need to go back
            x -= direction[0];
            y -= direction[1];
            
            // Recursively call the dfs function from these new coordinates, and if we find a path from here, return true
            if (dfs(maze, visited, new int[]{x, y}, destination)) {
                return true;
            }
        }
        
        // Return false if we were not able to find a path
        return false;
    }
    
    public boolean hasPathDFS(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, visited, start, destination);
    }
    
    public boolean hasPathBFS(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        
        int rows = maze.length;
        int cols = maze[0].length;
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start[0] * cols + start[1]);
        
        boolean[][] visited = new boolean[rows][cols];
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int oneDimension = queue.poll();
            int x = oneDimension / cols;
            int y = oneDimension % cols;
            
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                
                while (newX >= 0 && newX < rows && newY >= 0 && newY < cols && maze[newX][newY] == 0) {
                    newX += direction[0];
                    newY += direction[1];
                }
                
                newX -= direction[0];
                newY -= direction[1];
                
                if (newX == destination[0] && newY == destination[1]) {
                    return true;
                }
                
                if (!visited[newX][newY]) {
                    queue.offer(newX * cols + newY);
                    visited[newX][newY] = true;
                }
            }
        }
        
        return false;
}
