// LeetCode 7: Reverse Integer
// https://leetcode.com/problems/reverse-integer/

public class ReverseInteger {
    public int reverse(int x) {
        long reversed = 0;
        
        while (x != 0) {
            int remainder = x % 10;
            reversed = (reversed * 10) + remainder;
            
            if (reversed < Integer.MIN_VALUE || reversed > Integer.MAX_VALUE) {
                return 0;
            }
            
            x /= 10;
        }
        
        return (int) reversed;
    }
}
