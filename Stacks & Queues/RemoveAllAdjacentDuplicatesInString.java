// LeetCode 1047: Remove All Adjacent Duplicates In String
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        char[] stack = new char[S.length()];
        int stackLength = 0;

        for (char c : S.toCharArray()) {
            if (stackLength > 0 && c == stack[stackLength - 1]) {
                stackLength--;
            } else {
                stack[stackLength++] = c;
            }
        }

        return new String(stack, 0, stackLength);
    }
}