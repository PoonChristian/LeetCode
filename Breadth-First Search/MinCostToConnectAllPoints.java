// LeetCode 1584: Min Cost to Connect All Points
// https://leetcode.com/problems/min-cost-to-connect-all-points/

public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        // Extract the length
        int length = points.length;
        
        // Create the adjacency list
        List<List<int[]>> adjacencyList = new ArrayList<>(length);
        
        // Create an ArrayList at each index
        // Use the index from the points list to build and correspond to the adjacency list
        for (int i = 0; i < length; i++) {
            adjacencyList.add(new ArrayList<>()); // i : list of [node, cost]
        }
        
        // For each point in the points list, create the edges of the adjacency list
        for (int i = 0; i < length; i++) {
            // Get the x and y for the source point
            int x1 = points[i][0];
            int y1 = points[i][1];
            
            // Create an edge to each destination point, hence why we set j equal to i + 1
            for (int j = i + 1; j < length; j++) {
                // Get the x and y for the destination point
                int x2 = points[j][0];
                int y2 = points[j][1];

                // Manhattan Distance formula
                int manhattanDist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                
                // The graph is undirected, so add the edge between both nodes
                adjacencyList.get(i).add(new int[]{j, manhattanDist});
                adjacencyList.get(j).add(new int[]{i, manhattanDist});
            }
        }
        
        // Prim's Algorithm
        int minCost = 0;
        Set<Integer> visited = new HashSet<>();

        // Priority Queue will give priority to the edge with minimum cost 
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // Start from the first point at 0th index, with a cost of 0 since we haven't traversed yet
        minHeap.add(new int[]{0, 0});
        
        // Iterate while we haven't visited all the nodes, since Prim's algorithm will add node / cost pairs multiple times
        // We only care about the minimum cost, which would be calculated as soon as we visit all the nodes
        while (visited.size() < length) {
            // Extract the components of each node from the min heap
            int[] pair = minHeap.remove();
            int node = pair[0];
            int cost = pair[1];
            
            // Check if the node has already been visited, if so, then we can just move on to the next one
            if (visited.contains(node)) {
                continue;
            }
            
            // Add to our minCost and visit the node
            minCost += cost;
            visited.add(node);
            
            // Visit the neighbors of the node
            for (int[] neighbor : adjacencyList.get(node)) {
                if (!visited.contains(neighbor)) {
                    minHeap.add(new int[]{neighbor[0], neighbor[1]});
                }
            }
        }
        
        // Return the minCost
        return minCost;
    }
}
