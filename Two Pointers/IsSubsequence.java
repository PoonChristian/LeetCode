// LeetCode 392. Is Subsequence
// https://leetcode.com/problems/is-subsequence/

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            
            j++;
        }
        
        return i == s.length();
    }
}
