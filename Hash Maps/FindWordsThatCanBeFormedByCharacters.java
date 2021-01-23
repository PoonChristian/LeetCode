// LeetCode 1160: Find Words That Can Be Formed by Characters
// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] charCounts = new int[26];
        
        for (char c : chars.toCharArray()) {
            charCounts[c - 'a']++;
        }
        
        int numChars = 0;
        
        for (String word : words) {
            int[] charCountsCopy = charCounts.clone();
            boolean foundChars = true;
            
            for (char c : word.toCharArray()) {
                if (charCountsCopy[c - 'a'] == 0) {
                    foundChars = false;
                    break;
                }
                
                charCountsCopy[c - 'a']--;
            }
            
            if (foundChars) {
                numChars += word.length();
            }
        }
        
        return numChars;
    }
}