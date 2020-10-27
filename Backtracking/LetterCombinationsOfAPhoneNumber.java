// LeetCode 17: Letter Combinations of a Phone Number
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/

public class LetterCombinationsOfAPhoneNumber {

    private Map<Character, String> digitMap = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    private List<String> combinations = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return combinations;
        }

        getLetterCombinations(digits, new StringBuilder(), 0);
        return combinations;
    }

    public void getLetterCombinations(String digits, StringBuilder sb, int index) {
        if (index >= digits.length()) {
            combinations.add(sb.toString());
        } else {
            char digit = digits.charAt(index);
            for (char letter : digitMap.get(digit).toCharArray()) {
                sb.append(letter);
                getLetterCombinations(digits, sb, index + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}