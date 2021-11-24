// LeetCode 1347: Minimum Number of Steps to Make Two Strings Anagram
// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/

/*
    Algorithm:
        1. Store the counts of the characters first string
        2. Decrement the counts of the characters from the second string if it exists in the first string.
        3. Sum up the remaining characters with 1 or more occurrences to get the number of steps
*/
public class MinimumNumberOfStepsToMakeTwoStringsAnAnagram {
    public int minSteps(String s, String t) {
        int[] counts = new int[26];
        
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            if (counts[c - 'a'] > 0) {
                counts[c - 'a']--;
            }
        }
        
        int steps = 0;
        
        for (int i = 0; i < counts.length; i++) {
            steps += counts[i];
        }
        
        return steps;
    }
}
