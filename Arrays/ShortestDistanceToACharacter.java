// LeetCode 821: Shortest Distance to a Character
// https://leetcode.com/problems/shortest-distance-to-a-character/

public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String s, char c) {
        // Initialize the answer array that will hold the shortest distances at each index to char c
        int[] answer = new int[s.length()];

        // Keep track of the index for char c
        // Initialize it at -s.length() since c must fall within s
        //      This handles the first case when we haven't encountered the first index of char c
        int charIndex = -s.length();
        
        // Iterate from left to right
        for (int i = 0; i < s.length(); i++) {
            // Set the charIndex equal to i if we encounter it
            if (s.charAt(i) == c) {
                charIndex = i;
            }
            
            // Set answer[i] equal to i - charIndex
            // This basically means, get the distance between the current char and the location of the closest c to its left
            answer[i] = i - charIndex;
        }
        
        // Iterate from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            // Set the charIndex equal to i if we encounter it
            if (s.charAt(i) == c) {
                charIndex = i;
            }
            
            // Set answer[i] equal to the minimum between itself and the absolute difference between charIndex and i
            // Why Math.abs()?
            //      Because in the first iteration, charIndex could be less than i, so we want the absolute difference.
            //      Taking the absolute difference saves headache with potential negative numbers
            answer[i] = Math.min(answer[i], Math.abs(charIndex - i));
        }
        
        // Return the answer array
        return answer;
    }
}
