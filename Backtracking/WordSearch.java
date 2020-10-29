// LeetCode 79: Word Search
// https://leetcode.com/problems/word-search/submissions/

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(word, 0, board, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(String word, int index, char[][] board, int i, int j) {
        if (index == word.length()) {
            return true;
        } else if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(index)) {
            return false;
        } else {
            char temp = board[i][j];
            board[i][j] = ' ';
            boolean found = dfs(word, index + 1, board, i - 1, j) || dfs(word, index + 1, board, i + 1, j)
                    || dfs(word, index + 1, board, i, j - 1) || dfs(word, index + 1, board, i, j + 1);
            board[i][j] = temp;
            return found;
        }
    }
}