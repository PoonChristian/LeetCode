// LeetCode 102: Binary Tree Level Order Traversal
// https://leetcode.com/problems/binary-tree-level-order-traversal/

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();

        if (root == null) {
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<Integer>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                currentLevel.add(current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            levels.add(currentLevel);
        }

        return levels;
    }
}