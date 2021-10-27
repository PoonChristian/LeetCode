// LeetCode 1110: Delete Nodes And Return Forest
// https://leetcode.com/problems/delete-nodes-and-return-forest/

// Algorithm: Traverse the tree with bottom-up processing so we have a reference to the nodes we wanna keep. By processing bottom-up, we ensure we never lose a reference to nodes we wanna delete that are further down the tree.
public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // Initialize the result list
        List<TreeNode> remaining = new ArrayList<TreeNode>();
        
        // Use a HashSet rather than an array to allow O(1) access to the nodes we want to delete
        Set<Integer> deleteSet = new HashSet<Integer>();
        for (int num : to_delete) {
            deleteSet.add(num);
        }
        
        // Call a recursive function to traverse through the tree and find the nodes to delete
        removeNodes(root, remaining, deleteSet);
        
        // The recursive function doesn't check for the root node, so do a quick check to make sure we add the root node to the result if required
        if (!deleteSet.contains(root.val)) {
            remaining.add(root);
        }
        
        // Return the result list
        return remaining;
    }
    
    public TreeNode removeNodes(TreeNode root, List<TreeNode> remaining, Set<Integer> deleteSet) {
        // If the root is null, that means we've bottomed out, so just return null
        if (root == null) {
            return null;
        }
        
        // Traverse through the left and right subtrees and save the result of those calls to root.left and root.right
        root.left = removeNodes(root.left, remaining, deleteSet);
        root.right = removeNodes(root.right, remaining, deleteSet);
        
        // If we want to delete the current node, then check if it has a left subtree and a right subtree and add those subtrees to the result
        if (deleteSet.contains(root.val)) {
            if (root.left != null) {
                remaining.add(root.left);
            }
            
            if (root.right != null) {
                remaining.add(root.right);
            }
            
            // Return null after adding the subtrees because we want to delete the node
            // This return value will bubble back up to the root.left and root.right assignment calls, effectively removing the node from the tree
            return null;
        }
        
        // If we don't want to delete the current node, then just return itself so the root.left and root.right assignment calls still point to their original children
        return root;
    }
}
