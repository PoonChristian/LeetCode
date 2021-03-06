// LeetCode 415: Add Strings
// https://leetcode.com/problems/add-strings/

public class AddString {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }

        return sb.reverse().toString();
    }
}
