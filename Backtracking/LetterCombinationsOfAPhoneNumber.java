// LeetCode 17: Letter Combinations of a Phone Number
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/

public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }

        String[] mappings = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        getLetterCombinations(0, new StringBuilder(), mappings, digits, combinations);
        return combinations;
    }

    public void getLetterCombinations(int index, StringBuilder sb, String[] mappings, String digits,
             List<String> combinations) {
        if (index >= digits.length()) {
            combinations.add(sb.toString());
        } else {
            String letters = mappings[digits.charAt(index) - '0'];
            for (char c : letters.toCharArray()) {
                sb.append(c);
                getLetterCombinations(index + 1, sb, mappings, digits, combinations);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}