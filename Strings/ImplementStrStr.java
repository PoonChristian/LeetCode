// LeetCode 28: Implement strStr()
// https://leetcode.com/problems/implement-strstr/

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        // If the needle is empty, then we'll just return 0
        if (needle.equals("")) {
            return 0;
        }
        
        // We want to iterate until we reach the last index that we can evaluate against the needle
        // This is haystack.length() - needle.length() + 1
        // We add + 1 in order to include the very last index we can evaluate
        //      i.e.  The starting index of the last substring we can evaluate
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            String haystackSubstring = haystack.substring(i, i + needle.length());
            
            if (haystackSubstring.equals(needle)) {
                return i;
            }
        }
        
        // If we didn't find the needle in the haystack, then we return -1
        return -1;
    }
}
