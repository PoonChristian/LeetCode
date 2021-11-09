// LeetCode 13: Roman to Integer
// https://leetcode.com/problems/roman-to-integer/

public class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int romanVal = convertRomanToInt(s.charAt(i));
            
            if (i + 1 < s.length()) {
                int nextRomanVal = convertRomanToInt(s.charAt(i + 1));
                
                if (nextRomanVal > romanVal) {
                    result += nextRomanVal - romanVal;
                    i++;
                } else {
                    result += romanVal;
                }
            } else {
                result += romanVal;
            }
        }
        
        return result;
    }
    
    private int convertRomanToInt(char roman) {
        if (roman == 'I') {
            return 1;
        } else if (roman == 'V') {
            return 5;
        } else if (roman == 'X') {
            return 10;
        } else if (roman == 'L') {
            return 50;
        } else if (roman == 'C') {
            return 100;
        } else if (roman == 'D') {
            return 500;
        } else if (roman == 'M') {
            return 1000;
        } else {
            return 0;
        }
    }
}