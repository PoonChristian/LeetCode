// LeetCode 235: Lowest Common Ancestor of a Binary Tree
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If root is null, then return null
        if (root == null) {
            return null;
        }
        
        //  If root is either of the target values, then return the root because it must be the lowest common ancestor if it hits its target
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        
        // Recurse downward and get the base case results from the bottom-up
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If left is null, then the node on the right has to be the lowest common ancestor
        if (left == null) {
            return right;
        }
        
        // If right is null, then the node on the left has to be the lowest common ancestor
        if (right == null) {
            return left;
        }
        
        // If left and right are not null, then return root because it must be the lowest common ancestor
        return root;
    }
}
