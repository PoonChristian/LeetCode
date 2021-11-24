// LeetCode 58: Length of Last Word
// https://leetcode.com/problems/length-of-last-word/

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int length = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            // If the character is a letter, then we can increment length
            // Otherwise if length is greater than 0, it means we've already counted the last word so we can just break out
            if (Character.isLetter(s.charAt(i))) {
                length++;
            } else if (length > 0) {
                break;
            }
        }
        
        return length;
    }
}