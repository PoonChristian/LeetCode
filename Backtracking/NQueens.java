// LeetCode 51: N-Queens
// https://leetcode.com/problems/n-queens/

public class NQueens {
    // Helper class that stores the row and column of an instance
    class Position {
        int row;
        int col;
        
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        // Initialize solutions array
        List<List<String>> solutions = new ArrayList<List<String>>();

        // Initialize queen positions array
        Position[] positions = new Position[n];

        // Start the backtracking process
        backtrack(solutions, positions, n, 0);

        // Return the solutions
        return solutions;
    }
    
    public void backtrack(List<List<String>> solutions, Position[] positions, int n, int row) {
        // Base Case: If row == n, then we've reached a possible arrangement, so we should add it to our solution
        if (row == n) {
            solutions.add(generateBoard(positions, n));
            return;
        }
        
        // Find a column to place the queen in the row of this stack frame
        for (int col = 0; col < n; col++) {
            // Initialize a boolean flag to see if we've found a safe position to place our queen
            boolean foundSafe = true;
            
            // Loop over the queen positions array up until the current stack frame's row to ensure we can place the queen
            for (int queen = 0; queen < row; queen++) {
                // A position is unsafe if:
                // 1. The current column is the same as the column of an existing queen
                // 2. The position falls on the 45 degree diagonal (top left -> bottom right) of an existing queen (col - row)
                // 3. The position falls 135 degree diagonal (bottom left -> top right) of an existing queen (col + row)
                if (positions[queen].col == col || positions[queen].col - positions[queen].row == col - row || positions[queen].col + positions[queen].row == col + row) {
                    foundSafe = false;
                    break;
                }
            }
            
            // If the column at the current iteration is safe, then mark the position in the positions array
            // Afterwards, recursively call the backtracking function for the next row
            // NOTE: If there is no column in the future rows that work for this row's current column, the function will bubble back up and try a different column
            if (foundSafe) {
                positions[row] = new Position(row, col);
                
                backtrack(solutions, positions, n, row + 1);
            }
        }
    }
    
    // Helper function to generate the board in the case we found a solution
    public List<String> generateBoard(Position[] positions, int n) {
        // Initialize result that will represent the board
        List<String> result = new ArrayList<String>();
        
        // Iterate over the positions array (each iteration will represent a row)
        for (Position p : positions) {
            StringBuilder sb = new StringBuilder();

            // Iterate over the columns
            for (int i = 0; i < n; i++) {
                // Add "Q" if the current iteration matches the column in the positions array element
                // Otherwise add "."
                if (p.col == i) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }

            // Add the row to the final result
            result.add(sb.toString());
        }
        
        // Return the board
        return result;
    }
}
