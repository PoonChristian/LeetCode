// LeetCode 1911: Maximum Alternating Subsequence Sum
// https://leetcode.com/problems/maximum-alternating-subsequence-sum/
// Video Explanation: https://youtu.be/4v42XOuU1XA

public class MaximumAlternatingSubsequenceSum {
    public long maxAlternatingSum(int[] nums) {
        long sumEven = 0;
        long sumOdd = 0;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            long tempEven = Math.max(sumOdd + nums[i], sumEven);
            long tempOdd = Math.max(sumEven - nums[i], sumOdd);
            sumEven = tempEven;
            sumOdd = tempOdd;
        }
        
        return sumEven;
    }
}
