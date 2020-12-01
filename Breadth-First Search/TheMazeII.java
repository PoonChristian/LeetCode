// LeetCode 505: The Maze II
// https://leetcode.com/problems/the-maze-ii/
// Djikstra's Algorithm

public class TheMazeII {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private void djikstra(int[][] maze, int[] start, int[][] distances) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        
        pq.offer(new int[]{start[0], start[1], 0});
        
        while (!pq.isEmpty()) {
            int[] s = pq.poll();
            
            for (int[] direction : directions) {
                int x = s[0] + direction[0];
                int y = s[1] + direction[1];
                int path = 1;

                while (x >= 0 && x < maze.length && y >= 0 && y < maze[x].length && maze[x][y] == 0) {
                    x += direction[0];
                    y += direction[1];
                    path++;
                }

                x -= direction[0];
                y -= direction[1];
                path--;

                if (distances[s[0]][s[1]] + path < distances[x][y]) {
                    distances[x][y] = distances[s[0]][s[1]] + path;
                    pq.offer(new int[]{x, y, distances[x][y]});
                }
            }
        }
    }
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distances = new int[maze.length][maze[0].length];
        
        for (int[] row : distances) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        distances[start[0]][start[1]] = 0;
        
        djikstra(maze, start, distances);
        
        return distances[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distances[destination[0]][destination[1]];
    }
}
