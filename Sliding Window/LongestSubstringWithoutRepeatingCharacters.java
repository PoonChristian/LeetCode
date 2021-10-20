// Leetcode 3: Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // Quick null or empty string check
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // Initialize a set that keeps track of the unique characters in the longest substring
        Set<Character> charSet = new HashSet<Character>();
        
        // Initialize two variables i and j for the sliding window approach
        // i will point to the beginning of the string, j will point to the end of the string
        int i = 0;
        int j = 0;
        
        // Initialize a variable to keep track of the longest substring
        int longest = 1;
        
        // Iterate while the j pointer is not at the end of the input string
        while (j < s.length()) {
            // If the set doesn't contain the character at j, then add it and increment j.
            // Compute the longest substring again by getting the max of the current longest and the length between j and i
            // Note: We take j - i instead of j - i + 1 because we already incremented j in the previous line
            if (!charSet.contains(s.charAt(j))) {
                charSet.add(s.charAt(j++));
                longest = Math.max(longest, j - i);
            } else {
                // If the set contains the character at j, then move the i pointer up and remove its entry in the set
                // This operation will continue to happen until i moves past the first occurrence of the repeating character, which j is pointing at
                charSet.remove(s.charAt(i++));
            }
        }
        
        return longest;
    }
}
