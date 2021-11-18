// LeetCode 796: Rotate String
// https://leetcode.com/problems/rotate-string/

public class RotateString {
    public boolean rotateString(String s, String goal) {
        // If s is greater than goal, then s can never become goal no matter how many rotations there are, return false
        if (s.length() > goal.length()) {
            return false;
        }
        
        // Build string s + s
        StringBuilder sb = new StringBuilder();
        sb.append(s.repeat(2));
        
        // If goal is within s + s, then s can be rotated to become goal
        return sb.indexOf(goal) != -1;
    }
}
