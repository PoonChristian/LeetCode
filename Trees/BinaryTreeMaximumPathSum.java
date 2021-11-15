// LeetCode 124: Binary Tree Maximum Path Sum
// https://leetcode.com/problems/binary-tree-maximum-path-sum/

// Algorithm: Use a postorder traversal and bottom-up processing to compute sums
// and pass those sums to the parent while keeping track of the max along the way
public class BinaryTreeMaximumPathSum {
    // Keep track of the max and initialize it to the smallest negative number
    int max = Integer.MIN_VALUE;
    
    // Shell function that calls the postorder function and returns the max at the end
    public int maxPathSum(TreeNode root) {
        postorder(root);
        return max;
    }
    
    public int postorder(TreeNode root) {
        // If root is null, then just return 0
        if (root == null) {
            return 0;
        }
        
        // Traverse the left and right children of the root
        // Bound the answer to greater than or equal to 0 in order to ensure we get the maximum path sum
        // This is because a negative number will only make the path sum smaller
        int left = Math.max(postorder(root.left), 0);
        int right = Math.max(postorder(root.right), 0);
        
        // Update the max if root.val + left + right is greater than it
        max = Math.max(max, root.val + left + right);
        
        // Return the max between left and right + root.val
        // Because when recursing back up the tree, we only want one linear path
        return Math.max(left, right) + root.val;
    }
}
