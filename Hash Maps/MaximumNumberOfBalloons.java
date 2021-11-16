// LeetCode 1189: Maximum Number of Balloons
// https://leetcode.com/problems/maximum-number-of-balloons/

/*
    Two Algorithms involving Hash Table:
        1. Count the occurrences, and then continually scan through the string "balloon" until we don't have any of the requird characters to build the string anymore
        2. Count the occurrences, and then get the minimum of all the characters in "balloon" to determine how many strings we can make

    Time Complexity: O(n) because we have to iterate through the input text. We can possibly iterate more than once in the first approach, but this is still O(n)
    Space Complexity: O(1) because even though we store the counts in a char array, this char array will always be size 26, no matter how large the input string is
*/

public class MaximumNumberOfBalloons {
    public int maxNumberOfBalloonsScan(String text) {
        int[] charCounts = new int[26];
        
        for (char c : text.toCharArray()) {
            charCounts[c - 'a']++;
        }
        
        // Keep count of the number of times we can make the string "balloon"
        int numBalloons = 0;

        // Initialize the balloon string
        String balloon = "balloon";

        // Initialize a pointer to iterate through the balloon string
        int i = 0;
        
        // Iterate until the count of a character in "balloon" is 0, meaning we can't create the balloon string anymore
        while (charCounts[balloon.charAt(i) - 'a'] > 0) {
            // Subtract the count of the current character
            charCounts[balloon.charAt(i++) - 'a']--;
            
            // If we ever reach the end of the balloon string, that means we were able to build the string
            // Increment numBaloons and reset i back to 0 to try to build the string again
            if (i == balloon.length()) {
                numBalloons++;
                i = 0;
            }
        }
        
        // Return numBaloons to get the number of balloons
        return numBalloons;
    }
    
    public int maxNumberOfBalloonsMin(String text) {
        int[] charCounts = new int[26];
        
        for (char c : text.toCharArray()) {
            charCounts[c - 'a']++;
        }
        
        // 'b' -> 1
        int min = charCounts[1];
        
        // 'a' -> 0
        min = Math.min(min, charCounts[0]);
        
        // 'l' -> 11
        // divide the count by 2 because balloon requires two L's
        min = Math.min(min, charCounts[11] / 2);
        
        // 'o' -> 14
        // divide the count by 2 because balloon requires two o's
        min = Math.min(min, charCounts[14] / 2);
        
        // 'n' -> 13
        min = Math.min(min, charCounts[13]);
        
        return min;
    }
}