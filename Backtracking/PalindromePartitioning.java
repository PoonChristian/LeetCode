// LeetCode 131: Palindrome Partitioning
// https://leetcode.com/problems/palindrome-partitioning/

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> palindromes = new ArrayList<List<String>>();
        backtrack(palindromes, new ArrayList<String>(), s, 0);
        return palindromes;
    }

    public void backtrack(List<List<String>> palindromes, List<String> current, String s, int i) {
        if (i == s.length()) {
            palindromes.add(new ArrayList<String>(current));
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                current.add(s.substring(i, j + 1));
                backtrack(palindromes, current, s, j + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}