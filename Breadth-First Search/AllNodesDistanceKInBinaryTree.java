// LeetCode 863: All Nodes Distance K in Binary Tree
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

// Algorithm: Link each node to its parent with a HashMap to treat the tree like an undirected graph and then perform a BFS starting from target
public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Create a HashMap to map nodes to their parents with O(1) access
        Map<TreeNode, TreeNode> nodeToParent = new HashMap<>();
        
        // Traverse throught the tree and fill the nodeToParent map
        preorder(root, null, nodeToParent);
        
        // Initialize the result list
        List<Integer> nodesDistanceK = new ArrayList<>();
        
        // Initialize a queue for the BFS and start the BFS from the target
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        
        // Keep track of the current layer to make sure we stop traversing as soon as we hit the kth layer
        int currentLayer = 0;
        
        while (!queue.isEmpty() && currentLayer <= k) {
            // Extract the layer size
            int layerSize = queue.size();
            
            // Visit all nodes at the current layer
            for (int i = 0; i < layerSize; i++) {
                // Dequeue the node
                TreeNode current = queue.remove();
                
                // If we reached the kth layer, then just add the node's value to the list
                if (currentLayer == k) {
                    nodesDistanceK.add(current.val);
                } else {
                    // Note: If the nodeToParent map still contains the node, that means it hasn't been visited yet
                    
                    // Visit the left node if it hasn't been visited
                    TreeNode left = current.left;
                    if (left != null && nodeToParent.containsKey(left)) {
                        queue.add(left);
                    }
                    
                    // Visit the right node if it hasn't been visited
                    TreeNode right = current.right;
                    if (right != null && nodeToParent.containsKey(right)) {
                        queue.add(right);
                    }
                    
                    // Visit the parent if it hasn't been visited
                    TreeNode parent = nodeToParent.get(current);
                    if (parent != null && nodeToParent.containsKey(parent)) {
                        queue.add(parent);
                    }
                    
                    // Remove the node from the parent to ensure we don't visit it again
                    nodeToParent.remove(current);
                }
            }
            
            // Increment the current layer by 1
            currentLayer++;
        }
        
        // Return the list of nodes that have distance k from the target
        return nodesDistanceK;
    }
    
    // Preorder traversal to map nodes to their parents to treat the tree like a graph
    public void preorder(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> nodeToParent) {
        // If root is null, then just return out since there is no node to map
        if (root == null) {
            return;
        }
        
        // Map the root to its parent
        nodeToParent.put(root, parent);
        
        // Visit the left child, passing the root as its parent
        preorder(root.left, root, nodeToParent);
        
        // Visit the right child, passing the root as its parent
        preorder(root.right, root, nodeToParent);
    }
}
