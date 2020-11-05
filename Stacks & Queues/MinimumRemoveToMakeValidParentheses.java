// LeetCode 1249: Minimum Remove to Make Valid Parentheses
// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

public class MinimumRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        char[] sArray = s.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] == '(') {
                stack.push(i);
            } else if (sArray[i] == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sArray[i] = ' ';
                }
            }
        }
        
        while (!stack.isEmpty()) {
            sArray[stack.pop()] = ' ';
        }
        
        int index = 0;
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] != ' ') {
                sArray[index++] = sArray[i];
            }
        }
        
        return new String(sArray, 0, index);
    }
}