// LeetCode 137: Single Number II
// https://leetcode.com/problems/single-number-ii/

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        // Initialize our result variable
        int singleNum = 0;
        
        // Iterate over all 32 bit positions
        for (int i = 0; i < 32; i++) {
            // Keep track of a sum at each position
            int sum = 0;
            
            // Iterate through all numbers
            for (int num : nums) {
                // Right shift the current number by i bits and perform and & with 1 to ensure it is set to 1
                // If the value is 1, then increment our sum by 1
                if (((num >> i) & 1) == 1) {
                    sum++;
                }
            }
            
            // After going through all numbers, set sum = sum % 3
            // Why mod 3? Because every number except the single number occurs 3 times, so if the ith bit for the non-single number is set to 1, the ith bit for that non-single number will be added 3 times to sum
            // This mod operation will result in either 0 or 1 because 3 % 3 = 0 ((any multiple of 3) mod 3 = 0) and 1 % 3 = 1 (((any multiple of 3) + 1) mod 3 = 1)
            // Take the sum and add it to our result with a bitwise OR at the corresponding bit via left shift
            sum %= 3;
            singleNum |= sum << i;
        }
        
        // Return the XOR result
        return singleNum;
    }
}
