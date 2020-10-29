// LeetCode 22: Generate Parentheses
// https://leetcode.com/problems/generate-parentheses/

/*
Notes for this problem:
1) We can create strings of length n * 2, which means we can have n opening parenthesis and n closed parenthesis.
2) We will add 1 to numOpen every time we add an opening parenthesis.
3) We will subtract 1 from n and 1 from numOpen every time we create a well-formed parentheses.
4) We can only make 1 decision/option in the following cases.
    a) n == 0 and numOpen == 0: We've exhausted all possible pairs of parentheses, so we add the string into our answer.
    b) n == numOpen: We can only add closing parenthesis now since we can't create more than n opening parenthesis.
    c) numOpen == 0: We must add an opening parenthesis before we add any closing parenthesis.
5) If none of the conditions in #4 are true, then we have 2 decisions/options
    a) Add an opening parenthesis.
    b) Add a closing parenthesis. 
*/

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> parentheses = new ArrayList<String>();
        backtrack(parentheses, "(", n, 1);
        return parentheses;
    }

    public void backtrack(List<String> parentheses, String combination, int n, int numOpen) {
        if (n == 0 && numOpen == 0) {
            parentheses.add(combination);
        } else if (n == numOpen) {
            backtrack(parentheses, combination + ")", n - 1, numOpen - 1);
        } else if (numOpen == 0) {
            backtrack(parentheses, combination + "(", n, numOpen + 1);
        } else {
            backtrack(parentheses, combination + "(", n, numOpen + 1);
            backtrack(parentheses, combination + ")", n - 1, numOpen - 1);
        }
    }
}
