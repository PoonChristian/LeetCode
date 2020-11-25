// LeetCode 137: Single Number II
// https://leetcode.com/problems/single-number-ii/

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        // Initialize our XOR result variable
        int xor = 0;
        
        // Iterate over all 32 bit positions
        for (int i = 0; i < 32; i++) {
            // Keep track of a sum at each position
            int sum = 0;
            
            // Iterate through all numbers
            for (int j = 0; j < nums.length; j++) {
                // Right shift the current number by j bits and perform and & with 1 to ensure it is 1
                // If the value is 1, then increment our sum by 1
                if (((nums[j] >> i) & 1) == 1) {
                    sum++;
                }
            }
            
            // After going through all numbers, set sum = sum % 3
            // This will result in either 0 or 1 because 3 % 3 = 0 and 1 % 3 = 1
            // Take the sum and add it to our result at the corresponding bit via left shift
            sum %= 3;
            xor |= sum << i;
        }
        
        // Return the XOR result
        return xor;
    }
}
