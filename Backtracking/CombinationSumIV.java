// LeetCode 377: Combination Sum IV
// https://leetcode.com/problems/combination-sum-iv/

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return backtrack(nums, target, dp, 0);
    }

    public int backtrack(int[] nums, int target, int[] dp, int sum) {
        if (sum == target) {
            return 1;
        } else if (sum > target) {
            return 0;
        } else if (dp[sum] != -1) {
            return dp[sum];
        } else {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                count += backtrack(nums, target, dp, sum + nums[i]);
            }
            dp[sum] = count;
            return dp[sum];
        }
    }
}
