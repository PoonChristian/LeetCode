// LeetCode 20: Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char lastOpeningChar = stack.pop();
                if (lastOpeningChar == '(' && c != ')' || lastOpeningChar == '{' && c != '}'
                        || lastOpeningChar == '[' && c != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
