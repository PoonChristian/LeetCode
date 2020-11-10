// LeetCode 52: N-Queens II
// https://leetcode.com/problems/n-queens-ii/

public class NQueensII {
    public int totalNQueens(int n) {
        // Initialize boolean arrays to store columns and diagonals that are occupied throughout the backtracking process
        boolean[] occupiedCols = new boolean[n];
        boolean[] occupiedDiags1 = new boolean[2 * n - 1];
        boolean[] occupiedDiags2 = new boolean[2 * n - 1];
        
        // Return the result of the backtracking
        return backtrack(0, n, occupiedCols, occupiedDiags1, occupiedDiags2);
    }

    public int backtrack(int row, int n, boolean[] occupiedCols, boolean[] occupiedDiags1, boolean[] occupiedDiags2) {
        // Base Case: If row == n, that means we've reached a possible solution, so return 1
        if (row == n) {
            return 1;
        }
        
        // Initialize count, which will represent the number of possible solutions
        int count = 0;
        
        for (int col = 0; col < n; col++) {
            // Formula to get the 45 degree diagonal line corresponding to a row and column
            //      y = x + b
            //      b = y - x (where 0 <= b < 2n - 1)
            // We add n to the slope b because there is a chance that the slope might be negative
            // We subtract 1 from the slope to avoid index out of bounds exception
            // i.e. line drawn from top left going down to the right)
            //      \
            //       \
            int diag1 = col - row + n - 1;

            // Formula to get the 135 degree diagonal line corresponding to a row and column
            //      y = -x + b
            //      b = y + x (where 0 <= b < 2n - 1)
            // i.e. line drawn from bottom left going up to the right
            //      /
            //     /
            int diag2 = col + row;
            
            // Check if the value column and diagonals are already stored.
            // Do not choose the current row if they are stored.
            if (occupiedCols[col] || occupiedDiags1[diag1] || occupiedDiags2[diag2]) {
                continue;
            }

            // Mark the columns and diagonals as stored
            occupiedCols[col] = true;
            occupiedDiags1[diag1] = true;
            occupiedDiags2[diag2] = true;

            // Add the result of the backtracking to the count
            count += backtrack(row + 1, n, occupiedCols, occupiedDiags1, occupiedDiags2);

            // Mark the columns and diagonals as NOT stored in order to try a different board arrangement
            occupiedCols[col] = false;
            occupiedDiags1[diag1] = false;
            occupiedDiags2[diag2] = false;
        }
        
        // Return the count
        return count;
    }
}
