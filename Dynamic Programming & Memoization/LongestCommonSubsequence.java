// LeetCode 1143: Longest Common Subsequence
// https://leetcode.com/problems/longest-common-subsequence/
// Bottom Up and Top Down Solutions

public class LongestCommonSubsequence {
    private int findLength(String text1, String text2, int[][] memo, int ptr1, int ptr2) {
        if (ptr1 < 0 || ptr2 < 0) {
            return 0;
        }
        
        if (memo[ptr1][ptr2] != -1) {
            return memo[ptr1][ptr2];
        }
        
        if (text1.charAt(ptr1) == text2.charAt(ptr2)) {
            memo[ptr1][ptr2] = 1 + findLength(text1, text2, memo, ptr1 - 1, ptr2 - 1);
        } else {
            memo[ptr1][ptr2] = Math.max(findLength(text1, text2, memo, ptr1 - 1, ptr2), findLength(text1, text2, memo, ptr1, ptr2 - 1));
        }
        
        return memo[ptr1][ptr2];
    }
    
    public int longestCommonSubsequenceTopDown(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        
        return findLength(text1, text2, memo, text1.length() - 1, text2.length() - 1);
    }

    public int longestCommonSubsequenceBottomUp(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[text1.length()][text2.length()];
    }
}
