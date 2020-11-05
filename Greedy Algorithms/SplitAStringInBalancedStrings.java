// LeetCode 1221: Split a String in Balanced Strings
// https://leetcode.com/problems/split-a-string-in-balanced-strings/

public class SplitAStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        int numBalanced = 0;
        int direction = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                direction--;
            } else if (c == 'R') {
                direction++;
            }
            
            if (direction == 0) {
                numBalanced++;
            }
        }
        
        return numBalanced;
    }
}
