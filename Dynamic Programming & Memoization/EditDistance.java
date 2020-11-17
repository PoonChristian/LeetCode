// LeetCode 72: Edit Distance
// https://leetcode.com/problems/edit-distance/
// Top Down and Bottom Up Solutions

public class EditDistance {
    private int findMinDistance(String word1, int i, String word2, int j, int[][] memo) {
        // Base Case: If we ever reach the first row, return j to represent j insertions to transform empty string to word1.substring(0, j)
        if (i == 0) {
            return j;
        }
        
        // Base Case: If we ever reach the first column, return i to represent i deletions to transform word2.substring(0, i) to empty string
        if (j == 0) {
            return i;
        }
        
        // Return the value of this subproblem if we've already computed it
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        
        // if word1.charAt(i - 1) == word2.charAt(j - 1)
        //      dp[i][j] = dp[i - 1][j - 1]
        //      Reason: The minimum edit distance without the character is the same as with the character
        // else
        //      dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        //      Reason: We want the minimum number of operations whether it is replace, insert, or delete. Then add 1 more operation
        // Table Key:
        // Replace dp[i - 1][j - 1] | Delete  dp[i - 1][j]
        // Insert  dp[i][j - 1]     | Curr    dp[i][j]
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            memo[i][j] = findMinDistance(word1, i - 1, word2, j - 1, memo);
        } else {
            int replace = findMinDistance(word1, i - 1, word2, j - 1, memo);
            int delete = findMinDistance(word1, i - 1, word2, j, memo);
            int insert = findMinDistance(word1, i, word2, j - 1, memo);
            memo[i][j] = Math.min(replace, Math.min(delete, insert)) + 1;
        }
        
        // Return the value of this current subproblem
        return memo[i][j];
    }

    public int minDistanceTopDown(String word1, String word2) {
        // Initialize memo array to store the value of overlapping subproblems
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];

        // Return the min distance at the last row and last column of the matrix
        return findMinDistance(word1, word1.length(), word2, word2.length(), memo);
    }

    public int minDistanceBottomUp(String word1, String word2) {
        // Initialize dp table
        // Rows = word1 indices + 1 to account for empty string
        // Cols = word2 indices + 1 to account for empty string
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // Initialize every row's first column to be i
        // i represents the number of deletions to convert word2.substring(0, i) to an empty string 
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        // Initialize every column's first row to be j
        // j represents the number of insertions to convert an empty string to word1.substring(0, j)
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        
        // Iterate over the rest of the matrix and fill with the following formula
        // if word1.charAt(i - 1) == word2.charAt(j - 1)
        //      dp[i][j] = dp[i - 1][j - 1]
        //      Reason: The minimum edit distance without the character is the same as with the character
        // else
        //      dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        //      Reason: We want the minimum number of operations whether it is replace, insert, or delete. Then add 1 more operation
        // Table Key:
        // Replace dp[i - 1][j - 1] | Delete  dp[i - 1][j]
        // Insert  dp[i][j - 1]     | Curr    dp[i][j]
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        
        // The value at the bottom right cell of the matrix is the answer for the entire problem
        // because it represents the minimum operations to transform the entire word1 to the entire word2
        return dp[word1.length()][word2.length()];
    }
}
