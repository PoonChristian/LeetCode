// LeetCode 114: Flatten Binary Tree to Linked List
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        // Recursive function that will rearrange the tree into a linked list
        // flattenTree returns the tail of the new linked list, but we don't need that
        // So we are not storing the value of flattenTree
        flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode node) {
        // Base case: handle the null case
        if (node == null) {
            return null;
        }

        // Base case: return the node if it is a leaf
        if (node.left == null && node.right == null) {
            return node;
        }

        // Traverse the tree in bottom-up fashion

        // Traverse down the left side
        TreeNode leftTail = flattenTree(node.left);

        // Traverse down the right side
        TreeNode rightTail = flattenTree(node.right);

        // If there is a leftTail, rearrange its pointers so it's located on the right
        // Set the currrent node's left pointer to null
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        // If there is a rightTail, return it, otherwise return the leftTail
        return rightTail != null ? rightTail : leftTail;
    }
}
