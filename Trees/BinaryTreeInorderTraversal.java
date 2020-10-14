// LeetCode 94: Binary Tree Inorder Traversal
// https://leetcode.com/problems/binary-tree-inorder-traversal/
// Recursive, Iterative Stack, and Iterative Morris Traversal Solutions

public class BinaryTreeinorderTraversal {
    private void traverse(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }

        traverse(root.left, inorder);
        inorder.add(root.val);
        traverse(root.right, inorder);
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();
        traverse(root, inorder);
        return inorder;
    }

    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            inorder.add(curr.val);
            curr = curr.right;
        }

        return inorder;
    }

    public List<Integer> inorderTraversalMorris(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode predecessor = curr.left;
                while (predecessor.right != curr && predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    predecessor.right = null;
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return inorder;
    }
}