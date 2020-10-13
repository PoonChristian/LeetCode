// LeetCode 199: Binary Tree Right Side View
// https://leetcode.com/problems/binary-tree-right-side-view/
// Iterative and Recursive Solutions

public class BinaryTreeRightSideView {
    public List<Integer> rightSideViewIterative(TreeNode root) {
        List<Integer> rightNodes = new ArrayList<Integer>();

        if (root == null) {
            return rightNodes;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (i == 0) {
                    rightNodes.add(current.val);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }
            }
        }

        return rightNodes;
    }

    public List<Integer> rightSideViewRecursive(TreeNode root) {
        List<Integer> rightNodes = new ArrayList<Integer>();
        traverse(root, rightNodes, 0);
        return rightNodes;
    }

    private void traverse(TreeNode root, List<Integer> rightNodes, int depth) {
        if (root == null) {
            return;
        }

        if (depth >= rightNodes.size()) {
            rightNodes.add(root.val);
        }

        traverse(root.right, rightNodes, depth + 1);
        traverse(root.left, rightNodes, depth + 1);
    }
}
