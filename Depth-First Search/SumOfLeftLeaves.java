// LeetCode 404: Sum of Left Leaves
// https://leetcode.com/problems/sum-of-left-leaves/

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return findSum(root, false);
    }

    public int findSum(TreeNode root, boolean isLeftChild) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return isLeftChild ? root.val : 0;
        } else {
            return findSum(root.left, true) + findSum(root.right, false);
        }
    }
}
