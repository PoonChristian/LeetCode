// LeetCode 1002: Find Common Characters
// https://leetcode.com/problems/find-common-characters/

public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        int[] charCounts = new int[26];
        Arrays.fill(charCounts, Integer.MAX_VALUE);
        for (String s : A) {
            int[] count = new int[26];
            
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            
            for (int i = 0; i < 26; i++) {
                charCounts[i] = Math.min(charCounts[i], count[i]);
            }
        }
        
        List<String> commonChars = new ArrayList<String>();
        
        for (char c = 'a'; c <= 'z'; c++) {
            while (charCounts[c - 'a']-- > 0) {
                commonChars.add(String.valueOf(c));
            }
        }
        
        return commonChars;
    }
}
