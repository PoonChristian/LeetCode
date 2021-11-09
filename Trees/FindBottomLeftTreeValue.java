// LeetCode 513: Find Bottom Left Tree Value
// https://leetcode.com/problems/find-bottom-left-tree-value/

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        // Result will store maximum depth at the 0th index and bottom left tree value at the 1st index
        // Initialize both to be -1 to denote that we haven't encountered a maximum depth or bottom left value yet
        int[] result = new int[]{-1, -1};

        // Perform a postorder traversal to do process from the bottom left node upwards
        postorder(root, 0, result);

        // Return the value at the 1st index since it represents the bottom left value
        return result[1];
    }
    
    public void postorder(TreeNode root, int depth, int[] result) {
        // Base Case: Stop recursion if there are no more nodes to traverse
        if (root == null) {
            return;
        }
        
        // Traverse the left subtree and then the right subtree, while adding the depth
        postorder(root.left, depth + 1, result);
        postorder(root.right, depth + 1, result);
        
        // If the depth of the node we're currently on is ever greater than the maximum depth we've encountered, then update the result array accordingly
        if (depth > result[0]) {
            result[0] = depth;
            result[1] = root.val;
        }
    }
}
