// LeetCode 205: Isomorphic Strings
// https://leetcode.com/problems/isomorphic-strings/

/*
  Definition: Two strings are isomorphic if a one-to-one mapping is possible for every character of the first string to every character of the second string.
*/
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        // Two strings cannot be isomorphic if they have different lengths
        if (s.length() != t.length()) {
            return false;
        }
        
        // Extract the length to iterate over
        int len = s.length();
        
        // Initialize two int arrays
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        
        // Iterate over the length
        for (int i = 0; i < len; i++) {
            // If at any point, the value at the corresponding indices don't match, return false
            if (sMap[s.charAt(i)] != tMap[t.charAt(i)]) {
                return false;
            }
            
            // Mappings between two characters can be created by marking them with the same integer value
            // Note: Another way to do it is to map character to character (i.e e -> a, g -> d), but this requires a HashMap
            // We add 1 to i since the array contains 0's (meaning no mapping) at initialization
            sMap[s.charAt(i)] = i + 1;
            tMap[t.charAt(i)] = i + 1;
        }
        
        // Return true if we're ever able to reach the end of the strings
        return true;
    }
}
