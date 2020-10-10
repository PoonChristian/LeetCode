// LeetCode 530: Minimum Absolute Difference in BST
// https://leetcode.com/problems/minimum-absolute-difference-in-bst/

public class MinimumAbsoluteDifferenceInBST {
    Integer prev = null;
    int minDifference = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDifference;
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);

            if (prev != null) {
                minDifference = Math.min(root.val - prev, minDifference);
            }
            prev = root.val;

            inorder(root.right);
        }
    }
}