// LeetCode 389: Find the Difference
// https://leetcode.com/problems/find-the-difference/

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> sChars = new HashMap<Character, Integer>();

        for (char c : s.toCharArray()) {
            sChars.put(c, sChars.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            int current = sChars.getOrDefault(c, 0);
            if (current == 0) {
                return c;
            }
            sChars.put(c, current - 1);
        }

        return ' ';
    }
}
