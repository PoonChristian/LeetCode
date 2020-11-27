// LeetCode 1009: Complement of Base 10 Integer
// https://leetcode.com/problems/complement-of-base-10-integer/

public class ComplementOfBase10Integer {
    public int bitwiseComplement(int N) {
        /*
          This problem boils down to the realization that a number XORed by its complement is equal to 1.

          Example: 5 (101) and 2 (010)
          101 ^ 010 = 111

          With this realization in mind, we just need to find a bit mask of 1s and XOR that with N
          101 ^ 111 = 010 <-- this is our answer
        */

        // Initialize our bitmask to 1 since the least significant digit is 1
        int bitMask = 1;
        
        // Iterate while N is greater than the bit mask so we can fill up our bit mask with 1s up until N's most significant bit
        while (N > bitMask) {
            // Left shift our bit mask
            bitMask <<= 1;

            // Since left shift will make the least significant digit 0, we need to add 1
            // Note: Bitwise OR will also be valid in this case (bitMask |= 1)
            bitMask++;
        }
        
        // XOR both values to get the complement
        return N ^ bitMask;
    }
}