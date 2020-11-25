// LeetCode 139: Word Break
// https://leetcode.com/problems/word-break/
// Top Down and Bottom Up Solutions

public class WordBreak {
    private boolean dfs(String s, Set<String> wordSet, int start, Boolean[] memo) {
        // If we've reached the end of the string, we return true because that means we were able to reach the end using our wordSet
        if (start == s.length()) {
            return true;
        }
        
        // Return the value of the current subproblem if we've already computed it
        if (memo[start] != null) {
            return memo[start];
        }
        
        // Iterate from start + 1 to the end of the string to try the remaining possible substrings
        for (int end = start + 1; end <= s.length(); end++) {
            // If the wordSet contains the substring from start to end and the recursive call returns true,
            // it means we were able to reach the end of the string using all the words in our wordSet
            // Set the value of this current subproblem to true and break out immediately to prevent unnecessary computations
            if (wordSet.contains(s.substring(start, end)) && dfs(s, wordSet, end, memo)) {
                memo[start] = true;
                return true;
            }
        }
        
        // If we've tried all possible substrings from this subproblem and could not reach the end
        // Set the value of this current subproblem to false and return false
        memo[start] = false;
        return false;
    }

    public boolean wordBreakTopDown(String s, List<String> wordDict) {
        // Move all the dictionary words into a set for O(1) lookup time
        Set<String> wordSet = new HashSet<String>(wordDict);

        // Initialize a memo array to store the value of overlapping subproblems
        Boolean[] memo = new Boolean[s.length() + 1];

        // Perform a dfs with memoization to find whether or not this string can be created from the wordSet
        return dfs(s, wordSet, 0, memo);
    }

    public boolean wordBreakBottomUp(String s, List<String> wordDict) {
        // Move all the dictionary words into a set for O(1) lookup time
        Set<String> wordSet = new HashSet<String>(wordDict);

        // Initialize a dp array to store the value of overlapping subproblems
        boolean[] dp = new boolean[s.length() + 1];

        // Base Case: An empty string is a true case
        dp[0] = true;

        // Iterate from 1 to s.length() and utilize this variable as the end of the substring
        for (int end = 1; end <= s.length(); end++) {
            // Iterate from 0 to end to try all substrings from 0 to end
            for (int start = 0; start < end; start++) {
                // If the the subproblem at a starting position is true and the substring from start to end is in the wordSet
                // We can set this ending value to true and immediately break out to try the next ending value
                if (dp[start] && wordSet.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }

        // Return the last value in the dp array to represent the answer to the entire problem
        return dp[s.length()];
    }

}
