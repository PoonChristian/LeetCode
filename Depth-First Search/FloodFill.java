// LeetCode 733: Flood Fill
// https://leetcode.com/problems/flood-fill/

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        
        fill(image, sr, sc, image[sr][sc], newColor);
        
        return image;
    }
    
    public void fill(int[][] image, int i, int j, int oldColor, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j] != oldColor) {
            return;
        }
        
        image[i][j] = newColor;
        fill(image, i - 1, j, oldColor, newColor);
        fill(image, i, j + 1, oldColor, newColor);
        fill(image, i + 1, j, oldColor, newColor);
        fill(image, i, j - 1, oldColor, newColor);
    }
}
