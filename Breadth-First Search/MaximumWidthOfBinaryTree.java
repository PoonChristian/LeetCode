// LeetCode 662: Maximum Width of Binary Tree
// https://leetcode.com/problems/maximum-width-of-binary-tree/

public class MaximumWidthOfBinaryTree {
    // Define a class NodeWithIndex to keep track of indices
    private class NodeWithIndex {
        TreeNode node;
        int index;

        public NodeWithIndex(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        // If the root is null, return 0
        if (root == null) {
            return 0;
        }

        // 1. Define a queue with NodeWithIndex
        Queue<NodeWithIndex> queue = new LinkedList<NodeWithIndex>();

        // 2. Put the root with index in the queue
        queue.offer(new NodeWithIndex(root, 1));

        // 3. Define a maxWidth variable
        int maxWidth = 1;

        // 4.. While the queue is not empty, calculate the size at each level
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Initialize the positions
            int firstPos = -1;
            int lastPos = -1;

            // 5.. Remove the top values from the queue within a for loop over the size
            for (int i = 0; i < size; i++) {
                NodeWithIndex curr = queue.poll();
                TreeNode node = curr.node;
                int index = curr.index;

                // First position will only be updated once with the first index
                if (firstPos == -1) {
                    firstPos = index;
                }

                // Last position will update every time
                lastPos = index;

                // Add a new node with index at the left
                // newIndex = 2 * index
                if (node.left != null) {
                    queue.offer(new NodeWithIndex(node.left, 2 * index));
                }

                // newIndex = 2 * index + 1
                if (node.right != null) {
                    queue.offer(new NodeWithIndex(node.right, 2 * index + 1));
                }
            }

            // Update maxWidth with lastPos - firstPos + 1 if it's greater
            maxWidth = Math.max(maxWidth, lastPos - firstPos + 1);
        }

        // Return maxWidth
        return maxWidth;
    }
}
