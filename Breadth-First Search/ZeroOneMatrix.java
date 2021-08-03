// LeetCode 542: 01 Matrix
// https://leetcode.com/problems/01-matrix/

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        final int[][] directions = { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.add(i * cols + j); // Add the position to the queue (convert from 2D to 1D)
                } else {
                    mat[i][j] = -1; // Use -1 to mark as not visited
                }
            }
        }

        while (!queue.isEmpty()) {
            int z = queue.remove();
            int x = z / cols; // Get the row by dividing z with the number of columns
            int y = z % cols; // Get the column by modding z with the number of columns
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                // If the coordinate is out of bounds or it is not -1, that means it is a 0, so the distance will be 0; continue.
                if (newX < 0 || newX >= rows || newY < 0 || newY >= cols || mat[newX][newY] != -1) {
                    continue;
                }
                // The distance of the new coordinate will be the value at the current coordinate + 1
                mat[newX][newY] = mat[x][y] + 1;
                // Add the new coordinate to the queue to continue processing
                queue.add(newX * cols + newY);
            }
        }

        return mat;
    }
}
