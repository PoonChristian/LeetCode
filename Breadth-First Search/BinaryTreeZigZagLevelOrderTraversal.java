// LeetCode 103: Binary Tree Zigzag Level Order Traversal
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();

        if (root == null) {
            return levels;
        }

        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.offerLast(root);
        int row = 1;

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> currLevel = new ArrayList<Integer>();

            for (int i = 0; i < size; i++) {
                TreeNode currNode;

                if (row % 2 == 1) {
                    currNode = deque.pollFirst();

                    if (currNode.left != null) {
                        deque.offerLast(currNode.left);
                    }

                    if (currNode.right != null) {
                        deque.offerLast(currNode.right);
                    }
                } else {
                    currNode = deque.pollLast();

                    if (currNode.right != null) {
                        deque.offerFirst(currNode.right);
                    }

                    if (currNode.left != null) {
                        deque.offerFirst(currNode.left);
                    }
                }

                currLevel.add(currNode.val);
            }

            levels.add(currLevel);
            row++;
        }

        return levels;
    }
}
