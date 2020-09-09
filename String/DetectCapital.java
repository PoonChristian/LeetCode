// LeetCode 520: Detect Capital
// https://leetcode.com/problems/detect-capital/

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int capitals = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                capitals++;
            }
        }

        if (capitals == 0 || capitals == word.length()) {
            return true;
        }

        return capitals == 1 && Character.isUpperCase(word.charAt(0));
    }
}