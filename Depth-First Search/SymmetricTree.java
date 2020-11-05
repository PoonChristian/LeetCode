// LeetCode 101: Symmetric Tree
// https://leetcode.com/problems/symmetric-tree/
// Iterative and Recursive Solutions

public class SymmetricTree {
    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.remove();
            TreeNode right = queue.remove();

            if (left == null && right == null) {
                continue;
            } else if ((left == null || right == null) || (left.val != right.val)) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);

            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : isSymmetricRecursive(root.left, root.right);
    }

    private boolean isSymmetricRecursive(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        } else if (left.val != right.val) {
            return false;
        } else {
            return isSymmetricRecursive(left.left, right.right) && isSymmetricRecursive(left.right, right.left);
        }
    }
}
