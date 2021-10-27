// LeetCode 590: N-ary Tree Postorder Traversal
// https://leetcode.com/problems/n-ary-tree-postorder-traversal/

public class NaryTreePostorderTraversal {
    public List<Integer> postorderRecursive(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        traverse(result, root);
        return result;
    }
    
    public void traverse(List<Integer> result, Node root) {
        if (root == null) {
            return;
        }
        
        for (Node child : root.children) {
            traverse(result, child);
        }
        
        result.add(root.val);
    }

    public List<Integer> postorderIterative(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (root == null) {
            return result;
        }
        
        // Initialize a stack and a curr and prev node to keep track of where we are as we traverse the tree
        Stack<Node> stack = new Stack<Node>();
        Node curr = root;
        Node prev = null;
        
        // Iterate while curr is not pointing to null or while the stack is not empty
        while (curr != null || !stack.isEmpty()) {
            // Keep iterating to the left of the nary tree while we still can
            while (curr != null) {
                stack.push(curr);
                // We set curr equal to the leftmost child or null if it doesn't have any children
                curr = curr.children.isEmpty() ? null : curr.children.get(0);
            }
            
            // Set a temp node to the top of the stack to keep track of the node we are currently at
            Node temp = stack.peek();

            // Get the index of the previous node in the temp node's children
            int prevIndex = temp.children.indexOf(prev);

            // Check if there's another child to the right of our previous child by adding 1
            // If we haven't reached the end of the children's list yet, then set curr equal to the next child (this operation effectively traverses right)
            if (prevIndex + 1 < temp.children.size()) {
                curr = temp.children.get(prevIndex + 1);
            } else {
                // If there are no more children to process, then we know that we can add value of this node to our list
                // Pop it out of the stack
                stack.pop();

                // Set prev equal to our top node temp
                // This is important because it ensures we keep track of the last child node we processed. Then by grabbing its index and incrementing 1 in the above if statement, we can easily access the child right next to it
                prev = temp;

                // Add temp.val to our result
                result.add(temp.val);
            }
        }
        
        // Return the result array
        return result;
     }
}
