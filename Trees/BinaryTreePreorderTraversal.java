// LeetCode 144: Binary Tree Preorder Traversal
// https://leetcode.com/problems/binary-tree-preorder-traversal/
// Recursive, Iterative Stack, and Iterative Morris Traversal Solutions

public class BinaryTreePreorderTraversal {
    private void traverse(TreeNode root, List<Integer> preorder) {
        if (root == null) {
            return;
        }

        preorder.add(root.val);
        traverse(root.left, preorder);
        traverse(root.right, preorder);
    }

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();
        traverse(root, preorder);
        return preorder;
    }

    public List<Integer> preorderTraversalStack(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                preorder.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            curr = curr.right;
        }

        return preorder;
    }

    public List<Integer> preorderTraversalMorris(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                preorder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode predecessor = curr.left;
                while (predecessor.right != curr && predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = curr;
                    preorder.add(curr.val);
                    curr = curr.left;
                } else {
                    predecessor.right = null;
                    curr = curr.right;
                }
            }
        }

        return preorder;
    }
}