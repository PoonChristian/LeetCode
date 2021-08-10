// LeetCode 559: Maximum Depth of N-ary Tree
// https://leetcode.com/problems/maximum-depth-of-n-ary-tree/

public class MaximumDepthOfNaryTree {
    public int maxDepth(Node root) {
        // If the root is null, then the depth of the n-ary tree is 0
        if (root == null) {
            return 0;
        }

        // Initialize a depth variable to keep track of how deep the tree is
        int depth = 0;

        // Iterate over all children and recursively calculate the depth of each child
        // Set the top-level depth variable to be the max of itself and the child's depth
        for (Node child : root.children) {
            depth = Math.max(depth, maxDepth(child));
        }

        // Return the final depth (add 1 to include the root node)
        return depth + 1;
    }
}
