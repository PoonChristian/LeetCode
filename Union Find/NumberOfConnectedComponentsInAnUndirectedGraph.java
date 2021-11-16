// LeetCode 323: Number of Connected Components in an Undirected Graph
// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

// Time Complexity: O(n + m * log(n)) where n is the number of nodes and m is the number of edges
//      without path compression, the time complexity would be closer to O(n * m)
//      with path compression and the union by rank optimization (not included), the time complexity would be O(n + m * amortized log(n))
//          amortized log (n) is essentially constant, so the time complexity would be O(n + m)

// Space Complexity: O(n) where n is the number of nodes we have, since we create an array to keep track of subsets
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    // Merge two nodes together into one subset by setting the parent of node1 to the parent of node2
    // This means we need to find both parents and then assign one of the parents to point to the other
    private void union(int node1, int node2, int[] ids) {
        int parent1 = find(node1, ids);
        int parent2 = find(node2, ids);
        ids[parent1] = parent2;
    }

    // Find the parent of a given node
    private int find(int node, int[] ids) {
        // A node is a parent if its value matches its index
        // Example: ids[0] = 0, ids[1] = 1, etc.
        
        // If the node is not the parent of the subset, then we want to find it by recursively calling find on the node's parent (ids[node]) 
        if (ids[node] != node) {
            // Setting ids[node] = find(ids[node], ids) is what we do to perform path compression
            // Path compression means making all child nodes point directly to the parent
            ids[node] = find(ids[node], ids);
        }
        
        // By the end of the if statement, we know the node should point to the parent -> ids[node]
        // So just return ids[node]
        return ids[node];
    }

    public int countComponents(int n, int[][] edges) {
        // Initialize an empty array of size n
        int[] ids = new int[n];
        
        // Set the parent of each node to be itself (every node will be in its own subset)
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        
        // Iterate over the edges and perform a union on each edge
        for (int[] edge : edges) {
            union(edge[0], edge[1], ids);
        } 
        
        // Create a set to store the number of parents, which will denote unique components
        Set<Integer> components = new HashSet<Integer>();
        
        // Iterate over all the elements and perform a find on every node
        for (int i = 0; i < n; i++) {
            components.add(find(i, ids));
        }
        
        // Return the size of the set
        return components.size();
    }
}
