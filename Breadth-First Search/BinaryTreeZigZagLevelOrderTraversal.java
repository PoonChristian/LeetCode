// LeetCode 103: Binary Tree Zigzag Level Order Traversal
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();

        if (root == null) {
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int row = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> currLevel = new LinkedList<Integer>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (row % 2 == 1) {
                    currLevel.addLast(curr.val);
                } else {
                    currLevel.addFirst(curr.val);
                }

                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            levels.add(currLevel);
            row++;
        }

        return levels;
    }
}
