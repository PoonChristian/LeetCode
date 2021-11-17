// LeetCode 684: Redundant Connection
// https://leetcode.com/problems/redundant-connection/

// Algorithm: Standard union find code.
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        // Since the value of the edges will be [1,n], it's easier to add 1 to the length of the array and disregard the 0th index to make the math easier
        int[] parents = new int[n + 1];
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }
        
        // Same thing for ranks, add 1 to n to make the math for the union and find functions easier
        int[] ranks = new int[n + 1];
        Arrays.fill(ranks, 1);
        
        for (int[] edge : edges) {
            boolean unionRes = union(edge[0], edge[1], parents, ranks);
            
            // When we can't union an edge since both nodes already have the same parent, then we know that edge is what will cause the redundant connection
            if (!unionRes) {
                return edge;
            }
        }
        
        return new int[]{-1, -1};
    }
    
    private boolean union(int node1, int node2, int[] parents, int[] ranks) {
        int parent1 = find(node1, parents);
        int parent2 = find(node2, parents);
        
        if (parent1 == parent2) {
            return false;
        }
        
        if (ranks[parent1] >= ranks[parent2]) {
            parents[parent2] = parent1;
            ranks[parent1] += ranks[parent2];
        } else {
            parents[parent1] = parent2;
            ranks[parent2] += ranks[parent1];
        }
        
        return true;
    }
    
    private int find(int node, int[] parents) {
        while (parents[node] != node) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }
        
        return node;
    }
}
