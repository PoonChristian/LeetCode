// LeetCode 693: Binary Number with Alternating Bits
// https://leetcode.com/problems/binary-number-with-alternating-bits/

public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        // If n is 0, then the bits cannot be alternating
        if (n == 0) {
            return false;
        }
        
        // Get the value of the rightmost bit with (n & 1)
        int bit = n & 1;
        // Shift n to the right
        n >>= 1;
        
        // Iterate while n still has bits to check
        while (n > 0) {
            // If the bit value is equal to the last bit in n, then return false 
            if ((bit & 1) == (n & 1)) {
                return false;
            }
            
            // Flip the bit
            bit = ~bit;
            // Shift n to the right
            n >>= 1;
        }
        
        // If we reach the end of the loop, then we know all bits were alternating, return true
        return true;
    }
}
}