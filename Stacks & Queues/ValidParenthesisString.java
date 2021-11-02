// LeetCode 678: Valid Parenthesis String
// https://leetcode.com/problems/valid-parenthesis-string/

// Algorithm: Similar to ValidParentheses.java, except we keep track of the indices of the open parentheses. We will also keep track of the asterisks's indices in a separate stack.
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        // Initialize our stacks to store the open parentheses' and asterisks' indices
        Stack<Integer> openParentheses = new Stack<Integer>();
        Stack<Integer> asterisks = new Stack<Integer>();
        
        // Iterate through the input string
        for (int i = 0; i < s.length(); i++) {
            // Whenever we encounter an open parentheses, push its index into the open parentheses stack
            if (s.charAt(i) == '(') {
                openParentheses.push(i);
            } else if (s.charAt(i) == '*') {
                // Whenever we encounter an asterisk, push its index into the asterisk stack
                asterisks.push(i);
            } else {
                // If we reach this else statement, then we know we are dealing with a closing parentheses
                // We want to process all open parentheses first, since asterisks have more flexibility (it can be open, closing, or an empty string)
                
                // If there are open parentheses, then pop from the open parentheses stack to balance out the current closing parentheses
                if (!openParentheses.isEmpty()) {
                    openParentheses.pop();
                } else if (!asterisks.isEmpty()) {
                    // If there are no open parentheses, but we still have asterisks, pop the asterisk and treat it like an open parentheses to balance out the closing parentheses
                    asterisks.pop();
                } else {
                    // If there are no more open parentheses nor asterisks, then we can't balance this string - return false
                    return false;
                }
            }
        }
        
        // After iterating through the input string, we will have effectively balanced all closing parentheses
        // The only thing left to do is balance the remaining open parentheses

        // Therefore, iterate while we still have open parentheses to process
        while (!openParentheses.isEmpty()) {
            // If there are no more asterisks, then we can't balance out the remaining open parentheses - return false
            if (asterisks.isEmpty()) {
                return false;
            } else {
                // Otherwise, let's pop out the openIndex and asteriskIndex and see if we can balance out the open parentheses
                int openIndex = openParentheses.pop();
                int asteriskIndex = asterisks.pop();
                
                // Condition: If asteriskIndex is less than the openIndex, then the asterisk is before the open parentheses and cannot be balanced, so return false --> *...(
                if (asteriskIndex < openIndex) {
                    return false;
                }

                // If we pass the above condition, then means asteriskIndex is greater than openIndex, and therefore can be properly balanced --> (...*
            }
        }
        
        // If we exhausted all the open parentheses, then just return true
        // We don't care how many asterisks we have left since they can be converted to an empty string
        return true;
    }
}
