// LeetCode 145: Binary Tree Postorder Traversal
// https://leetcode.com/problems/binary-tree-postorder-traversal/
// Recursive and Iterative Stack Solutions

public class BinaryTreePostorderTraversal {
    private void traverse(TreeNode root, List<Integer> postorder) {
        if (root == null) {
            return;
        }

        traverse(root.left, postorder);
        traverse(root.right, postorder);
        postorder.add(root.val);
    }

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> postorder = new ArrayList<Integer>();
        traverse(root, postorder);
        return postorder;
    }

    public List<Integer> postorderTraversalStack(TreeNode root) {
        LinkedList<Integer> postorder = new LinkedList<Integer>();

        if (root == null) {
            return postorder;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            postorder.addFirst(curr.val);

            if (curr.left != null) {
                stack.push(curr.left);
            }

            if (curr.right != null) {
                stack.push(curr.right);
            }
        }

        return postorder;
    }
}
