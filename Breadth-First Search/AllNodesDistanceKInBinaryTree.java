// LeetCode 863: All Nodes Distance K in Binary Tree
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

// Algorithm: Link each node to its parent with a HashMap to treat the tree like an undirected graph and then perform a BFS starting from target
public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> nodeToParent = new HashMap<TreeNode, TreeNode>();
        dfs(root, null, nodeToParent);
        
        List<Integer> nodesDistanceK = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(target);
        int currentLayer = 0;
        
        while (!queue.isEmpty() && currentLayer <= K) {
            int layerSize = queue.size();
            
            for (int i = 0; i < layerSize; i++) {
                TreeNode current = queue.poll();
                
                if (currentLayer == K) {
                    nodesDistanceK.add(current.val);
                } else {
                    if (current.left != null && nodeToParent.containsKey(current.left)) {
                        queue.offer(current.left);
                    }

                    if (current.right != null && nodeToParent.containsKey(current.right)) {
                        queue.offer(current.right);
                    }

                    TreeNode parent = nodeToParent.get(current);
                    if (parent != null && nodeToParent.containsKey(parent)) {
                        queue.offer(parent);
                    }
                    
                    nodeToParent.remove(current);
                }
            }
            
            currentLayer++;
        }
        
        return nodesDistanceK;
    }
    
    public void dfs(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> nodeToParent) {
        if (root == null) {
            return;
        }
        
        nodeToParent.put(root, parent);
        dfs(root.left, root, nodeToParent);
        dfs(root.right, root, nodeToParent);
    }
}
