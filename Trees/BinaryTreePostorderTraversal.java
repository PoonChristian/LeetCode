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
        List<Integer> postorder = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        
        // Iterate while curr is not null or while the stack still has elements to process
        while (curr != null || !stack.isEmpty()) {
            // Push all the nodes and keep traversing left
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // Set temp to be the top node's right child
            TreeNode temp = stack.peek().right;
            
            // If temp is null, that means the top node doesn't have a child, so we can immediately pop it and add it to our postorder
            if (temp == null) {
                temp = stack.pop();
                postorder.add(temp.val);
                
                // We want to iterate again and check if the node we just popped is a right child of the stack's top node
                // If so, that means we can safely process the stack's top node
                // We must use a while loop and not an if statement in case we have a tree that falls completely to the right
                while (!stack.isEmpty() && temp == stack.peek().right) {
                    temp = stack.pop();
                    postorder.add(temp.val);
                }
            } else {
                curr = temp;
            }
        }
        
        return postorder;
    }
}
