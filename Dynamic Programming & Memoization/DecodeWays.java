// LeetCode 91: Decode Ways
// https://leetcode.com/problems/decode-ways/
// Bottom Up and Top Down Solutions

public class DecodeWays {    
    private int calculateNumDecodings(String s, int index, Integer[] memo) {
        if (index == s.length()) {
            return 1;
        } else if (memo[index] != null) {
            return memo[index];
        } else {
            int result = 0;
            
            int firstNum = Integer.parseInt(s.substring(index, index + 1));
            if (firstNum >= 1) {
                result += calculateNumDecodings(s, index + 1, memo);
            }
            
            if (index < s.length() - 1) {
                int secondNum = Integer.parseInt(s.substring(index, index + 2));
                if (secondNum >= 10 && secondNum <= 26) {
                    result += calculateNumDecodings(s, index + 2, memo);
                }
            }

            memo[index] = result;
            return memo[index];
        }
    }

    public int numDecodingsTopDown(String s) {
        Integer[] memo = new Integer[s.length()];
        return calculateNumDecodings(s, 0, memo);
    }

    public int numDecodingsBottomUp(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 2; i <= s.length(); i++) {
            int firstNum = Integer.parseInt(s.substring(i - 1, i));
            
            if (firstNum >= 1) {
                dp[i] += dp[i - 1];
            }
            
            int secondNum = Integer.parseInt(s.substring(i - 2, i));
            
            if (secondNum >= 10 && secondNum <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }
}