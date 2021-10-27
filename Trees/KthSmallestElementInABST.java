// LeetCode 230: Kth Smallest Element in a BST
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        // Initialize a result array that simply keeps track of the index we're currently on and the answer
        int[] result = new int[2];

        // Do an inorder traversal since it will process the tree in ascending order
        inorder(root, result, k);

        // Return the value at the 1st index since it will store the answer
        return result[1];
    }
    
    public void inorder(TreeNode root, int[] result, int k) {
        // If the root is null at any point, return out
        if (root == null) {
            return;
        }
        
        // Traverse to the left node of the root
        inorder(root.left, result, k);
        
        // We do ++result[0] because the indices are 1-based, so we increment first and then check for equality
        // By using an array, we only modify the current index we're on at this step rather than passing in an index at the end
        // If we reach the kth smallest element, then set result[1] = root.val and return out to prevent further processing since we've already found the element that we want
        if (++result[0] == k) {
            result[1] = root.val;
            return;
        }
        
        // Traverse to the right node of the root
        inorder(root.right, result, k);
    }
}