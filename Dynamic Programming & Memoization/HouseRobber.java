// LeetCode 198: House Robber
// https://leetcode.com/problems/house-robber/

// Algorithm: Use bottom-up processing to determine the maximum money we can rob at the ith house
public class HouseRobber {
    public int rob(int[] nums) {
        /*
        Simple Cases:
            1. nums is null or has no elements -> there is no money to rob, so return 0
            2. nums has 1 element -> we can only rob from one house, so return nums[0]
            3. nums has 2 elements -> we can rob from either house, so take the max between the two

        Interesting Case:
            If we have more than 2 houses, then we have to compare between robbing and not robbing a house
            We can't rob adjacent houses. This means if we want to rob nums[i], we can't rob nums[i - 1] and we must rob nums[i - 2]
            Store the results at each iteration in a dp array, then the last value of our dp array will store our maximum amount of money we can rob
        */
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }

            return dp[nums.length - 1];
        }
    }
}