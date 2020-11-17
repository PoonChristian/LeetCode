// LeetCode 1143: Longest Common Subsequence
// https://leetcode.com/problems/longest-common-subsequence/
// Top Down and Bottom Up Solutions

public class LongestCommonSubsequence {
    private int findLength(String text1, String text2, int[][] memo, int ptr1, int ptr2) {
        // If either ptr is ever below 0, then that means one of the strings is empty and we can't have a LCS, so return 0
        if (ptr1 < 0 || ptr2 < 0) {
            return 0;
        }
        
        // Return the value of this subproblem if we've already computed it
        if (memo[ptr1][ptr2] != -1) {
            return memo[ptr1][ptr2];
        }
        
        // If the text1 and text2 share the same character at their respective indices,
        //      Count it (add 1) and continue looking through the string without that character
        // Otherwise
        //      Take the maximum between chopping off 1 character in text1 or chopping off 1 character in text2
        if (text1.charAt(ptr1) == text2.charAt(ptr2)) {
            memo[ptr1][ptr2] = 1 + findLength(text1, text2, memo, ptr1 - 1, ptr2 - 1);
        } else {
            memo[ptr1][ptr2] = Math.max(findLength(text1, text2, memo, ptr1 - 1, ptr2), findLength(text1, text2, memo, ptr1, ptr2 - 1));
        }
        
        // Return the value of this current subproblem
        return memo[ptr1][ptr2];
    }
    
    public int longestCommonSubsequenceTopDown(String text1, String text2) {
        // Initialize memo array to store the value of overlapping subproblems
        int[][] memo = new int[text1.length()][text2.length()];
        
        // Fill the memo array with -1 to denote that we haven't calculate the subproblems yet
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        
        // Return the value at the last row and last column of the memo matrix
        return findLength(text1, text2, memo, text1.length() - 1, text2.length() - 1);
    }

    public int longestCommonSubsequenceBottomUp(String text1, String text2) {
        // Initialize a dp table
        // Rows = text1.length() + 1 to account for empty string
        // Cols = text2.length() + 1 to account for empty string
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        // Iterate starting from the first row and the first column
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                // If the characters are ever equal (subtract 1 because we're accounting for empty string in the dp table)
                //      Set the current cell to be 1 + the cell diagonally left above it
                //      Reason: The cell at the top left diagonal represents the value without the current character
                // Otherwise, take the maximum between chopping off 1 character in text1 and chopping off 1 character in text2
                //      Set the current cell to be the maximum between the cell above it or the cell left of it
                //      Reason: The cell above is the value without the character in text2 and the cell to the left is the value without the character in text1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Return the value of the last row and last column in the dp table
        return dp[text1.length()][text2.length()];
    }
}
