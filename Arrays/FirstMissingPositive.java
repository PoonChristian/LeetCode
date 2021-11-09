// LeetCode 41: First Missing Positive
// https://leetcode.com/problems/first-missing-positive/

public class FirstMissingPositive {
    // Algorithm: Store all nums in a set, then iterate from 1 until we can't find the number in the set. The first number we can't find is the answer.
    public int firstMissingPositiveLinearSpace(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        
        int n = nums.length;
        
        Set<Integer> uniqueNums = new HashSet<>();
        
        for (int num : nums) {
            uniqueNums.add(num);
        }
        
        int min = 1;
        
        while (uniqueNums.contains(min)) {
            min++;
        }
        
        return min;
    }

    // Algorithm (3 iterations):
    // 1. Iterate through the array and look for a 1. Also convert 0, negatives, and numbers greater than n to 1 since those are just noise.
    // 2. If we found a 1, then iterate through and get the index (nums[i] - 1 represents the zero-based index). If the number at that index is positive, then make it negative.
    // 3. Iterate through the array one more time, and the index + 1of the first positive number will represent the first missing positive
    // 4. Edge Case: If all numbers were marked negative, then the first missing positive is simply n + 1
    public int firstMissingPositiveConstantSpace(int[] nums) {
        // Return 1 if the array is empty or null
        if (nums == null || nums.length == 0) {
            return 1;
        }
        
        // Store nums.length in variable n
        int n = nums.length;

        // Use a boolean flag to see if we encounter a 1 in the first iteration
        boolean containsOne = false;
        
        // Make sure all numbers fall in range [1, n] inclusive
        // Numbers that aren't in this range should be marked as 1 as a placeholder
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                containsOne = true;
            } else if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        
        // If there is no 1, then we know 1 is the missing number. Return it immediately.
        if (!containsOne) {
            return 1;
        }
        
        // Use the nums[i] as an index, but subtract 1 since arrays are zero based.
        // Also use Math.abs(nums[i]) in order to prevent accessing negative indices
        // Only mark the value at the index negative if it is a positive number
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        
        // Iterate one more time
        // The index + 1 of the first positive value will be the missing number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        
        // Edge Case: All the numbers within range [1, n] inclusive were marked negative (meaning they all started out as positive)
        // Therefore, the missing number will be n + 1
        return n + 1;
    }
}
