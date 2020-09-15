// LeetCode 242: Valid Anagram
// https://leetcode.com/problems/valid-anagram/
// LowercaseOnly and AllUnicode characters solutions

public class ValidAnagram {
    public boolean lowercaseOnly(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean allUnicode(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            sMap.put(t.charAt(i), sMap.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (Character key : sMap.keySet()) {
            if (sMap.get(key) != 0) {
                return false;
            }
        }

        return true;
    }
}