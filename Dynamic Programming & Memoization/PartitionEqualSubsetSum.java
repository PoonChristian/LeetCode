// LeetCode 416: Partition Equal Subset Sum
// https://leetcode.com/problems/partition-equal-subset-sum/
// Top Down and Bottom Up Solutions

public class PartitionEqualSubsetSum {
    private boolean canPartition(int[] nums, int subsetSum, int index, Boolean[][] memo) {
        if (subsetSum == 0) {
            return true;
        } else if (index == 0 || subsetSum < 0) {
            return false;
        } else if (memo[index][subsetSum] != null) {
            return memo[index][subsetSum];
        } else {
            boolean possiblePartition = canPartition(nums, subsetSum - nums[index], index - 1, memo) || canPartition(nums, subsetSum, index - 1, memo);
            memo[index][subsetSum] = possiblePartition;
            return memo[index][subsetSum];
        }
    }

    public boolean canPartitionTopDown(int[] nums) {
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 == 1) {
            return false;
        }
        
        int subsetSum = sum / 2;
        Boolean[][] memo = new Boolean[nums.length][subsetSum + 1];
        
        return canPartition(nums, subsetSum, nums.length - 1, memo);
    }

    public boolean canPartitionBottomUp(int[] nums) {
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 == 1) {
            return false;
        }
        
        int subsetSum = sum / 2;
        
        boolean[][] dp = new boolean[nums.length + 1][subsetSum + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= nums.length; i++) {
            int curr = nums[i - 1];
            for (int j = 0; j <= subsetSum; j++) {
                dp[i][j] = j >= curr ? dp[i - 1][j] || dp[i - 1][j - curr] : dp[i - 1][j];
            }
        }
        
        return dp[nums.length][subsetSum];
    }

    public boolean canPartitionBottomUpOptimizedSpace(int[] nums) {
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 == 1) {
            return false;
        }
        
        int subsetSum = sum / 2;
        boolean[] dp = new boolean[subsetSum + 1];
        dp[0] = true;
        
        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        return dp[subsetSum];
    }
}
