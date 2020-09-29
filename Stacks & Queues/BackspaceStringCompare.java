// LeetCode 844: Backspace String Compare
// https://leetcode.com/problems/backspace-string-compare/
// Two Stack and Two Pointer Solutions

public class BackspaceStringCompare {
    public boolean twoStackSolution(String S, String T) {
        Stack<Character> sStack = new Stack<Character>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c != '#') {
                sStack.push(c);
            } else if (!sStack.isEmpty()) {
                sStack.pop();
            }
        }

        Stack<Character> tStack = new Stack<Character>();
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (c != '#') {
                tStack.push(c);
            } else if (!tStack.isEmpty()) {
                tStack.pop();
            }
        }

        if (sStack.size() != tStack.size()) {
            return false;
        }

        while (!sStack.isEmpty()) {
            if (sStack.pop() != tStack.pop()) {
                return false;
            }
        }

        return true;
    }

    public boolean twoPointerSolution(String S, String T) {
        int sIndex = S.length() - 1;
        int tIndex = T.length() - 1;

        while (sIndex >= 0 || tIndex >= 0) {
            sIndex = nextChar(S, sIndex);
            tIndex = nextChar(T, tIndex);

            if (sIndex >= 0 && tIndex >= 0 && S.charAt(sIndex) != T.charAt(tIndex)) {
                return false;
            }

            if ((sIndex >= 0) != (tIndex >= 0)) {
                return false;
            }

            sIndex--;
            tIndex--;
        }

        return true;
    }

    private int nextChar(String str, int index) {
        int skips = 0;

        while (index >= 0) {
            if (str.charAt(index) == '#') {
                skips++;
                index--;
            } else if (skips > 0) {
                skips--;
                index--;
            } else {
                break;
            }
        }

        return index;
    }
}