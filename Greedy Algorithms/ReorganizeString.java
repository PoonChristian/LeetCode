// LeetCode 767: Reorganize String
// https://leetcode.com/problems/reorganize-string/

public class ReorganizeString {
    public String reorganizeString(String S) {
        // Initialize a counts array to store the counts of each character
        int[] counts = new int[26];
        for (int i = 0; i < S.length(); i++) {
            counts[S.charAt(i) - 'a']++;
        }
        
        // Find the most frequent character and its index without sorting 
        int maxFreq = 0;
        int maxIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > maxFreq) {
                maxFreq = counts[i];
                maxIndex = i;
            }
        }
        
        // If the count of the most frequent character is more than half of the input string's length
        // Then it won't be possible to reorganize this string such that every adjacent character is different
        if (maxFreq > (S.length() + 1) / 2) {
            return "";
        }
        
        // Initialize a char array for our reorganized string
        char[] result = new char[S.length()];

        // Initialize an index to fill the string at particular points
        int index = 0;

        // Fill the char array with the most frequent character first, at every even index (0, 2, 4, 6, etc.)
        while (counts[maxIndex] > 0) {
            result[index] = (char) (maxIndex + 'a');
            index += 2;
            counts[maxIndex]--;
        }
        
        // Iterate over the rest of the counts array
        for (int i = 0; i < counts.length; i++) {
            // If we ever find a frequency greater than 0, then process this character
            while (counts[i] > 0) {
                // If our index has reached the string's length, then reset it to 1
                // Note: This condition will only trip once after filling the most frequent character since we know our string is long enough to fill all our remaining characters
                if (index >= S.length()) {
                    index = 1;
                }
                
                // Fill the char array the same way we filled it with the most frequent character
                result[index] = (char) (i + 'a');
                index += 2;
                counts[i]--;
            }
        }
        
        // Return our newly organized string
        return new String(result);
    }
}
