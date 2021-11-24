// LeetCode 438: Find All Anagrams in a String
// https://leetcode.com/problems/find-all-anagrams-in-a-string/

// Algorithm: Keep track of two character count arrays of size 26 and compare them for each window of size p.length() in s
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagramStarts = new ArrayList<>();
        
        // If the length of string s is less than the length of string p, then p cannot be found in s, so return an empty list
        if (s.length() < p.length()) {
            return anagramStarts;
        }
        
        // Initialize both character arrays to store the counts
        int[] pCounts = new int[26];
        int[] sCounts = new int[26];
        
        // Store the counts of the first p.length() characters
        for (int i = 0; i < p.length(); i++) {
            pCounts[p.charAt(i) - 'a']++;
            sCounts[s.charAt(i) - 'a']++;
        }
        
        // If the values in the arrays are equal, then we know we found a window at the very beginning of string s, which is an anagram of p
        // Add 0 since we want to add the starting indices
        if (equalArrays(pCounts, sCounts)) {
            anagramStarts.add(0);
        }
        
        // Initialize the left end of the sliding window
        int i = 0;
        
        // Initialize the right end of the sliding window at the length of p and iterate until the end of string s
        for (int j = p.length(); j < s.length(); j++) {
            // Increment the count of the character at j (right end)
            sCounts[s.charAt(j) - 'a']++;

            // Decrement the count of the character at i (left end) and increment the i pointer to move to left end of the window
            sCounts[s.charAt(i++) - 'a']--;
            
            // Check if the arrays are equal and if they are, then add i
            if (equalArrays(sCounts, pCounts)) {
                anagramStarts.add(i);
            }
        }
        
        // Return the final list
        return anagramStarts;
    }
    
    // Helper function to check if two arrays of size 26 are equal
    private boolean equalArrays(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        
        return true;
    }
}