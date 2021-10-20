// LeetCode 111. Minimum Depth of Binary Tree
// https://leetcode.com/problems/minimum-depth-of-binary-tree/

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        
        // If there is no left child or no right child, then take the depth of the non-null child and add 1 (the root)
        // Otherwise, get the minimum between the non-null left and right children, then add 1 (the root)
        return (leftDepth == 0 || rightDepth == 0) ? leftDepth + rightDepth + 1 : Math.min(leftDepth, rightDepth) + 1;
    }
}
