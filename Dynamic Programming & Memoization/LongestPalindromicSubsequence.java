// LeetCode 516: Longest Palindromic Subsequence
// https://leetcode.com/problems/longest-palindromic-subsequence/
// Top Down and Bottom Up Solutions

public class LongestPalindromicSubsequence {
    private int longestPalindromeSubseqRecursive(String s, int i, int j, int[][] memo) {
        // If i is ever greater than j, then we've reached the middle and exhausted all characters, so return 0
        if (i > j) {
            return 0;
        }

        // If i is ever equal to j, that means we're on the same character, so return 1
        if (i == j) {
            return 1;
        }

        // Return the value of this subproblem if we've already computed it
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        // If the character at i is the same as the character at j
        //      Set the value to be 2 (to account for both characters) + the value of the recursive call without the character (i + 1, j - 1)
        // Otherwise
        //      Set the value to be the maximum between considering character i (the first character) or considering character j (the last character)
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = 2 + longestPalindromeSubseqRecursive(s, i + 1, j - 1, memo);
        } else {
            memo[i][j] = Math.max(longestPalindromeSubseqRecursive(s, i + 1, j, memo), longestPalindromeSubseqRecursive(s, i, j - 1, memo));
        }

        // Return the value of the current subproblem
        return memo[i][j];
    }

    public int longestPalindromeSubseqTopDown(String s) {
        // Initialize memo array to store the value of overlapping subproblems
        int[][] memo = new int[s.length()][s.length()];

        // Return the longest palindrome subsequence of the entire string
        return longestPalindromeSubseqRecursive(s, 0, s.length() - 1, memo);
    }

    public int longestPalindromeSubseqBottomUp(String s) {
        // Initialize dp table
        // dp[i][j] represents the longest palindromic subsequence of the substring between i and j range inclusive
        int[][] dp = new int[s.length()][s.length()];
        
        // Iterate starting from the bottom right cell
        for (int i = s.length() - 1; i >= 0; i--) {
            // Set the cell at diagonal dp[i][i] = 1
            // Reason: Longest palindromic subsequence of a string of length 1 is equal to 1
            dp[i][i] = 1;

            // Iterate starting from i + 1 to s.length()
            for (int j = i + 1; j < s.length(); j++) {
                // If the character at i is equal to the character at j
                //      Set the value to be 2 (to account for both characters) + the value of its top left cell
                // Otherwise get the max of considering character i or considering character j
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Return the value at the top right cell to get the longest palindromic subsequence of the entire string
        return dp[0][s.length() - 1];
    }
}
