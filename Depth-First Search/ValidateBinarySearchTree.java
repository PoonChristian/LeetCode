// LeetCode 98: Validate Binary Search Tree
// https://leetcode.com/problems/validate-binary-search-tree/

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, null, null);
    }

    public boolean checkBST(TreeNode root, Integer left, Integer right) {
        if (root == null) {
            return true;
        } else if (left != null && root.val <= left || right != null && root.val >= right) {
            return false;
        } else {
            return checkBST(root.left, left, root.val) && checkBST(root.right, root.val, right);
        }
    }
}