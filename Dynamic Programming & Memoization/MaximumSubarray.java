// LeetCode 53: Maximum Subarray
// https://leetcode.com/problems/maximum-subarray/
// Greedy and Dynamic Programming Solutions

public class MaximumSubarray {

    public int maxSubArrayGreedy(int[] nums) {
        int finalMax = nums[0];
        int runningMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // We add the current number if it yields a greater result than the current number itself
            // Otherwise, start a new contiguous subarray with the current number
            runningMax = Math.max(runningMax + nums[i], nums[i]);
            finalMax = Math.max(finalMax, runningMax);
        }

        return finalMax;
    }

    public int maxSubArrayDP(int[] nums) {
        int max = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // We only want to add if the value before is positive
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }

            max = Math.max(nums[i], max);
        }

        return max;
    }
}
