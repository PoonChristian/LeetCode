// LeetCode 268: Missing Number
// https://leetcode.com/problems/missing-number/
// Math and Bit Manipulation Approaches

public class MissingNumber {
    public int missingNumberMath(int[] nums) {
        // Initialize n
        int n = nums.length;

        // Leverage the fact that the sum of the first n natural numbers is equal to (n * (n + 1)) / 2
        int missing = (n * (n + 1)) / 2;
        
        // Loop over the array and subtract all the numbers from the sum
        for (int i = 0; i < n; i++) {
            missing -= nums[i];
        }
        
        // When the loop terminates, we should be left with the missing number
        return missing;
    }

    public int missingNumberBitManipulation(int[] nums) {
        // Initialize missing to be the length of the array
        int missing = nums.length;

        // Iterate over all the nums
        for (int i = 0; i < nums.length; i++) {
            // x ^ x = 0, so if a number matches its index, then i ^ nums[i] = 0
            missing ^= i ^ nums[i];
        }

        // By the end of all the XOR operations, we should be left with the missing number
        return missing;
    }
}