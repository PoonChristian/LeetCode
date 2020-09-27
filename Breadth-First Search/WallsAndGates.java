// LeetCode 286: Walls and Gates
// https://leetcode.com/problems/walls-and-gates/

public class WallsAndGates {

    private class Coordinate {
        public int x;
        public int y;
        public int steps;

        public Coordinate(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }

    public void wallsAndGates(int[][] rooms) {

        // Iterate through the grid, and add all gates into the queue

        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new Coordinate(i, j, 0));
                }
            }
        }

        // Initialize directions to traverse the grid (up, right, down, left)

        final int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        // Run BFS from all gates

        while (!queue.isEmpty()) {

            // Get the current coordinate from the queue and extract its x, y, and # of
            // steps

            Coordinate current = queue.remove();
            int x = current.x;
            int y = current.y;
            int steps = current.steps;

            // Check all four directions from this coordinate

            for (int[] direction : directions) {

                // Get the new coordinates after moving a certain direction

                int newX = x + direction[0];
                int newY = y + direction[1];

                // Update value at newX and newY if:
                // 1. The new coordinates are in-bounds
                // 2. The value at the coordinate is INF

                if (newX >= 0 && newX < rooms.length && newY >= 0 && newY < rooms[newX].length
                        && rooms[newX][newY] == Integer.MAX_VALUE) {

                    // Set the new room value to be the number of steps taken plus 1
                    // Add this new coordinate to the queue

                    rooms[newX][newY] = steps + 1;
                    queue.add(new Coordinate(newX, newY, steps + 1));

                }
            }
        }
    }

}
