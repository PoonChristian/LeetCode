// LeetCode 1380: Lucky Numbers in a Matrix
// https://leetcode.com/problems/lucky-numbers-in-a-matrix/

public class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        // Initialize the result list
        List<Integer> luckyNumbers = new ArrayList<>();
        
        // Iterate through the entire matrix
        for (int i = 0; i < matrix.length; i++) {
            // Keep track of the minimum of each row and its column within the matrix
            // Initialize both to MAX_VALUE and -1 to denote that it has not been found yet
            int rowMin = Integer.MAX_VALUE;
            int colIndex = -1;
            
            // Iterate through the columns of the current row
            for (int j = 0; j < matrix[i].length; j++) {
                // If the current value at i, j is less than the min, then update accordingly
                if (matrix[i][j] < rowMin) {
                    rowMin = matrix[i][j];
                    colIndex = j;
                }
            }
            
            // Determine whether or not the min we found is the max in its column
            // If so, then add it to our result
            if (maxInColumn(matrix, colIndex) == rowMin) {
                luckyNumbers.add(rowMin);
            }
        }
        
        // Return the result
        return luckyNumbers;
    }
    
    // Helper function that gets the max of a column
    private int maxInColumn(int[][] matrix, int colIndex) {
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < matrix.length; i++) {
            max = Math.max(max, matrix[i][colIndex]);
        }
        
        return max;
    }
}
