// LeetCode 1002: Find Common Characters
// https://leetcode.com/problems/find-common-characters/

// Algorithm: Keep track of a global counts array and get the character counts for each individual word and update the global counts array with the minimum character counts for each word. The characters with counts greater than 0 are the common characters.
public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        int[] charCounts = new int[26];
        Arrays.fill(charCounts, Integer.MAX_VALUE);
        
        for (String s : words) {
            int[] count = new int[26];
            
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            
            for (int i = 0; i < 26; i++) {
                charCounts[i] = Math.min(charCounts[i], count[i]);
            }
        }
        
        List<String> commonChars = new ArrayList<>();
        
        for (char c = 'a'; c <= 'z'; c++) {
            while (charCounts[c - 'a']-- > 0) {
                commonChars.add(String.valueOf(c));
            }
        }
        
        return commonChars;
    }
}
