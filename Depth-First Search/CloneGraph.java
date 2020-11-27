// LeetCode 133: Clone Graph
// https://leetcode.com/problems/clone-graph/

public class CloneGraph {
    public Node cloneGraph(Node node) {
        // If node is null, then there's no graph to clone, so return null
        if (node == null) {
            return null;
        }
        
        // Initialize a map where key-value pairs are { node.val : clonedNode }
        // All nodes in the graph have unique values so this will work
        Map<Integer, Node> map = new HashMap<Integer, Node>();
        
        // Return the result of a depth-first search starting from our node
        return dfs(map, node);
    }
    
    public Node dfs(Map<Integer, Node> map, Node node) {
        // If the map contains the value of the node, then we've already visited it in our dfs, so return its cloned node
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        
        // Create the clone node and put it into the map
        Node clone = new Node(node.val);
        map.put(node.val, clone);
        
        // Iterate over all the neighbors
        for (Node neighbor : node.neighbors) {
            // Add the result of the dfs from the neighbor into our current clone's neighbors
            clone.neighbors.add(dfs(map, neighbor));
        }
        
        // Return the clone
        return clone;
    }
}
