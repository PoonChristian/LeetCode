// LeetCode 1382: Balance a Binary Search Tree
// https://leetcode.com/problems/balance-a-binary-search-tree/

// Algorithm: Construct a list representing the BST's inorder traversal, and then build a new BST that is balanced
public class BalanceABinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();
        
        traverse(inorder, root);
        
        int left = 0;
        int right = inorder.size() - 1;
        
        return constructBST(inorder, left, right);
    }
    
    // Algorithm is similar to ConvertSortedArrayToBinarySearchTree.java
    public TreeNode constructBST(List<Integer> inorder, int left, int right) {
        if (left > right) {
            return null;
        }
        
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = constructBST(inorder, left, mid - 1);
        root.right = constructBST(inorder, mid + 1, right);
        return root;
    }
    
    // Standard inorder traversal
    public void traverse(List<Integer> inorder, TreeNode root) {
        if (root == null) {
            return;
        }
        
        traverse(inorder, root.left);
        inorder.add(root.val);
        traverse(inorder, root.right);
    }
}
