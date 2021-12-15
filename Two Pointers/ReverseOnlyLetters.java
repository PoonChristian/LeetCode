// LeetCode 917: Reverse Only Letters
// https://leetcode.com/problems/reverse-only-letters/

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        // Get the char array for string s and initialize two pointers to iterate towards the middle
        char[] sArray = s.toCharArray();
        int i = 0;
        int j = sArray.length - 1;
        
        while (i < j) {
            // If the character at index i is not a letter, then increment i in order to skip it
            while (i < j && !Character.isLetter(sArray[i])) {
                i++;
            }
            
            // If the character at index j is not a letter, then decrement j in order to skip it
            while (i < j && !Character.isLetter(sArray[j])) {
                j--;
            }
            
            // Swap the letters, increment i, and decrement j
            char temp = sArray[i];
            sArray[i++] = sArray[j];
            sArray[j--] = temp;
        }
        
        // Return the character array as a string
        return new String(sArray);
    }
}
