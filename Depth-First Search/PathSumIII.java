// LeetCode 437: Path Sum III
// https://leetcode.com/problems/path-sum-iii/

// This problem is the same idea as Subarray Sum Equals K,
// except the data structure is a binary tree.

// Refer to SubarraySumEqualsK.java in the Hash Map directory for more info.

public class PathSumIII {
    int numPaths;
    Map<Integer, Integer> map;

    public int pathSum(TreeNode root, int sum) {
        numPaths = 0;
        map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        dfs(root, sum, 0);
        return numPaths;
    }

    private void dfs(TreeNode root, int sum, int currentSum) {
        if (root == null) {
            return;
        }

        currentSum += root.val;

        if (map.containsKey(currentSum - sum)) {
            numPaths += map.get(currentSum - sum);
        }

        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

        dfs(root.left, sum, currentSum);
        dfs(root.right, sum, currentSum);

        // As we recurse back up, we must subtract 1 from the current sum count
        // This is because we will be exploring a different path
        // WITHOUT the value at the current node
        map.put(currentSum, map.get(currentSum) - 1);
    }
}
