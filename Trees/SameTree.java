// LeetCode 100: Same Tree
// LeetCode https://leetcode.com/problems/same-tree/
// Recursive and Iterative Solutions

public class SameTree {
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTreeRecursive(p.left, q.left) && isSameTreeRecursive(p.right, q.right);
        }
    }

    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {
            TreeNode pNode = queue.remove();
            TreeNode qNode = queue.remove();

            if (pNode == null && qNode == null) {
                continue;
            } else if (pNode == null || qNode == null || pNode.val != qNode.val) {
                return false;
            }

            queue.add(pNode.left);
            queue.add(qNode.left);

            queue.add(pNode.right);
            queue.add(qNode.right);
        }

        return true;
    }
}
