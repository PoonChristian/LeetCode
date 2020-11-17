// LeetCode 5: Longest Palindromic Substring
// https://leetcode.com/problems/longest-palindromic-substring/
// Bottom Up and Expand From Middle Solutions

public class LongestPalindromicSubstring {
    public String longestPalindromeBottomUp(String s) {
        // Quick check for null or empty string, return empty string if so
        if (s == null || s.length() == 0) {
            return "";
        }
        
        // Initialize boolean dp table and variables to determine the start and end positions of the longest substring
        // dp[i][j] = whether or not s.substring(i, j) range inclusive is a palindrome
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0;
        int end = 0;
        int maxLength = 1;
        
        // Iterate starting from the last row
        for (int i = s.length() - 1; i >= 0; i--) {
            // Base Case: s.substring(i, i) range inclusive will always be a palindrome
            dp[i][i] = true;
            
            for (int j = i + 1; j < s.length(); j++) {
                // Base Case: s.substring(i, i + 1) is a palindrome as long as character i is the same as character i + 1
                if (j == i + 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    // Check if character i and j are the same and if the string without those characters is a palindrome
                    // Set dp[i][j] = true if so
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                
                // If the current substring is a palindrome and its length is longer than the maxLength
                //      Set the new start and end positions along with its new maxLength
                //      Note: We add 1 to the length because of zero-based indexing
                if (dp[i][j] && j - i + 1 > maxLength) {
                    start = i;
                    end = j;
                    maxLength = j - i + 1;
                }
            }
        }
        
        // Return the substring with range (start, end + 1)
        // We add 1 to end since the last index is exclusive in Java
        return s.substring(start, end + 1);
    }

    public String longestPalindromeExpandFromMiddle(String s) {
        // Quick check for null or empty string, return empty string if so
        if (s == null || s.length() == 0) {
            return "";
        }

        // Set starting and ending positions and update as we loop through the string
        int start = 0;
        int end = 0;

        // Iterate over the string
        for (int i = 0; i < s.length(); i++) {
            // Expand directly from the middle of the string
            int len1 = expandFromMiddle(s, i, i);
            
            // Expand from the characters left of middle and right of middle of the string
            int len2 = expandFromMiddle(s, i, i + 1);
            
            // Take the maximum of these lengths to account for even and odd lengthed cases
            int maxLength = Math.max(len1, len2);
            
            // If the maxLength is greater than the difference between our end and starting positions, set the new start and end position around this length
            // Note: For start, we take (maxLength - 1) to account for zero-based indexing
            if (maxLength > end - start) {
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }

        // Return the substring from start to end + 1 since the ending bound is exclusive
        return s.substring(start, end + 1);
    }

    public int expandFromMiddle(String s, int left, int right) {
        // Keep moving the left pointer to the left and right pointer to the right
        // as long as the characters at each pointer are the same
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Return right - left - 1 to get the distance
        // Reason: At the end of the above while loop, left and right will go out of the palindrome's bounds,
        //         so we need to increase left by 1 unit and decrease right by 1 unit to account for that overflow.
        //         From there we add 1 to get the length from left to right.
        //              (right - 1) - (left + 1) + 1
        //              right - 1 - left - 1 + 1
        //              right - left - 2 + 1
        //              right - left - 1
        return right - left - 1;
    }
}
