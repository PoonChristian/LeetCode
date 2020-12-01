// LeetCode 323: Number of Connected Components in an Undirected Graph
// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    // Merge two nodes together into one subset by setting the parent of node1 to the parent of node2
    private void union(int node1, int node2, int[] ids) {
        int parent1 = find(node1, ids);
        int parent2 = find(node2, ids);
        ids[parent1] = parent2;
    }

    // Find the parent of a given node
    private int find(int node, int[] ids) {
        if (ids[node] != node) {
            // Perform path compression so all nodes point directly to the parent
            ids[node] = find(ids[node], ids);
        }
        
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
