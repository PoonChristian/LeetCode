// LeetCode 938: Range Sum of BST
// https://leetcode.com/problems/range-sum-of-bst/

public class RangeSumOfBST {
    private int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        dfs(root, low, high);
        return sum;
    }

    public void dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        } else if (root.val < low) {
            dfs(root.right, low, high);
        } else if (root.val > high) {
            dfs(root.left, low, high);
        } else {
            sum += root.val;
            dfs(root.left, low, high);
            dfs(root.right, low, high);
        }
    }

    public int rangeSumBSTBottomUp(TreeNode root, int low, int high) {
        return sumWithinBounds(root, low, high, 0);
    }

    public int sumWithinBounds(TreeNode root, int low, int high, int sum) {
        if (root == null) {
            return sum;
        } else if (root.val < low) {
            return sumWithinBounds(root.right, low, high, sum);
        } else if (root.val > high) {
            return sumWithinBounds(root.left, low, high, sum);
        } else {
            int leftSum = sumWithinBounds(root.left, low, high, sum);
            int rightSum = sumWithinBounds(root.right, low, high, sum);
            return root.val + leftSum + rightSum;
        }
    }
}