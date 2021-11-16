// LeetCode 419: Battleships in a Board
// https://leetcode.com/problems/battleships-in-a-board/

public class BattleshipsInABoard {
    // This question is pretty much the same as Number of Islands (https://leetcode.com/problems/number-of-islands/), except the battleships can only be horizontal (1 x k) or vertical (k x 1)
    // Similar DFS code from Number of Islands can be used to solve this problem
    public int countBattleshipsRecursive(char[][] board) {
        int battleships = 0;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    sink(board, i, j);
                    battleships++;
                }
            }
        }
        
        return battleships;
    }
    
    // This sink function will dfs through the battleship and "sink it" by changing it's values from 'X' to '.'
    public void sink(char[][] boards, int i, int j) {
        if (i < 0 || i >= boards.length || j < 0 || j >= boards[i].length || boards[i][j] == '.') {
            return;
        }
        
        boards[i][j] = '.';
        sink(boards, i - 1, j);
        sink(boards, i, j + 1);
        sink(boards, i + 1, j);
        sink(boards, i, j - 1);
    }
    // This function does not use a DFS, but it leverages two facts
    // 1. We traverse through a 2-D array top to bottom, left to right
    // 2. A battleship can only be horizontal or vertical

    // If we find the first X, then increment battleships
    public int countBattleshipsIterative(char[][] board) {
        int battleships = 0;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // If the cell is empty, just continue through the loop because empty cells don't contribute to our answer
                if (board[i][j] == '.') {
                    continue;
                }
                
                // Vertical Check
                // If the cell above is an X, then we've already counted this battleship
                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                }
                
                // Horizontal Check
                // If the cell to the left is an X, then we've already counted this battleship
                if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }
                
                // Otherwise, if none of the if statements execute, that means we've found the first X, so increment battleships
                battleships++;
            }
        }
        
        return battleships;
    }
}
