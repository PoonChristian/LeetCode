// LeetCode 387: First Unique Character in a String
// https://leetcode.com/problems/first-unique-character-in-a-string/
// LowercaseOnly and AllUnicode characters solutions

public class FirstUniqueCharacterInAString {
    public int lowercaseOnly(String s) {
        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public int allUnicode(String s) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();

        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (charMap.get(s.charAt(i) - 'a') == 1) {
                return i;
            }
        }

        return -1;
    }
}
