// LeetCode 1119: Remove Vowels from a String
// https://leetcode.com/problems/remove-vowels-from-a-string/

public class RemoveVowelsFromAString {
    private boolean isVowel(char letter) {
        char c = Character.toLowerCase(letter);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
    public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < S.length(); i++) {
            if (!isVowel(S.charAt(i))) {
                sb.append(S.charAt(i));
            }
        }
        
        return sb.toString();
    }
}
