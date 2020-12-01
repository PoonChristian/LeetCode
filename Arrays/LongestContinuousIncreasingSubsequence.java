// LeetCode 674: Longest Continuous Increasing Subsequence
// https://leetcode.com/problems/longest-continuous-increasing-subsequence/

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int longest = 1;
        int current = 1;
        
        for (int i = 1; i < nums.length; i++) {
            current = nums[i] > nums[i - 1] ? current + 1 : 1;
            longest = Math.max(longest, current);
        }
        
        return longest;
    }
}
