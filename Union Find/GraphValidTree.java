// LeetCode 261: Graph Valid Tree
// https://leetcode.com/problems/graph-valid-tree/

public class GraphValidTree {
    //================================================================================
    // Union Find
    //================================================================================

    // Union function that returns true if union is possible and false if already joined and can't be unioned
    private boolean union(int node1, int node2, int[] groups) {
        int parent1 = find(node1, groups);
        int parent2 = find(node2, groups);

        if (parent1 != parent2) {
            groups[parent1] = parent2;
            return true;
        } else {
            return false;
        }
    }
    
    // Find the group that a node belongs to
    private int find(int node, int[] groups) {
        while (node != groups[node]) {
            // Path compression
            groups[node] = groups[groups[node]];
            // Set personNum equal to groups[node] to continue the search
            node = groups[node];
        }
        
        return node;
    }
    
    public boolean validTreeUnionFind(int n, int[][] edges) {
        // A valid tree must have an edge connecting all n nodes, this would add up to n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        // Create a groups array where groups[i] is equal to the group number that index i belongs to
        int[] groups = new int[n];
        
        // Set each index to belong to their own groups
        for (int i = 0; i < n; i++) {
            groups[i] = i;
        }
        
        for (int[] edge : edges) {
            // If two nodes are already in the same group, that means there already exists path between both nodes
            // Therefore the edge that is not able to complete the union is the one that causes the cycle
            if (!union(edge[0], edge[1], groups)) {
                return false;
            }
        }
        
        return true;
    }

    //================================================================================
    // Depth-First Search
    //================================================================================

    private boolean hasNoCycle(List<List<Integer>> graph, int start, int parent, Set<Integer> visited) {
        visited.add(start);
        
        for (int end : graph.get(start)) {
            if (end == parent) {
                continue;
            }
            
            if (visited.contains(end)) {
                return false;
            }
            
            boolean isValidTree = hasNoCycle(graph, end, start, visited);
            
            if (!isValidTree) {
                return false;
            } 
        }
        
        return true;
    }
    
    public boolean validTreeDFS(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        
        List<List<Integer>> adjacencyList = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<Integer>();
        
        return hasNoCycle(adjacencyList, 0, -1, visited) && visited.size() == n;
    }
}
