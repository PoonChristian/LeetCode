// LeetCode 151: Reverse Words in a String
// https://leetcode.com/problems/reverse-words-in-a-string/

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        // If the string is null or empty, just return s immediately
        if (s == null || s.length() == 0) {
            return s;
        }
        
        // Get all the words within the string and put it into an array
        String[] words = s.trim().split("\\s+");
        
        // If there's only 1 word, just return the original string because there's nothing to reverse
        if (words.length == 1) {
            return s;
        }
        
        // Initialize two pointers to reverse the words array
        int i = 0;
        int j = words.length - 1;
        
        // Iterate while i < j in order to reverse all the words
        while (i < j) {
            String temp = words[i];
            words[i++] = words[j];
            words[j--] = temp;
        }
        
        // Initialize a StringBuilder to store the final result
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < words.length; index++) {
            // Append each word and an empty space to the StringBuilder
            sb.append(words[index] +  " ");
        }

        // Return the string associated with the StringBuilder and then trim it to remove the trailing whitespace
        return sb.toString().trim();
    }
}
