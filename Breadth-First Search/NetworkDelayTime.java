// LeetCode 743: Network Delay Time
// https://leetcode.com/problems/network-delay-time/

// Algorithm: Use Djikstra's algorithm to find the minimum time it takes to visit all nodes
// Note: The following terms will be used interchangebly: vertex / node, time / weight
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create the adjacency list
        // We use n + 1 for the size since node values are between [1,n] inclusive
        List<List<int[]>> adjacencyList = new ArrayList<>(n + 1);
        
        // Create an ArrayList at each index
        for (int i = 0; i < n + 1; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        // Each index will be a vertex, and it will have a list of directed edges
        // The list will contain an int array of size 2 at each index
        // 0th index = destination vertex
        // 1st index = weight / time of the edge
        for (int i = 0; i < times.length; i++) {
            adjacencyList.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }
        
        // Initialize a min heap that prioritizes values based on time / weight
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // Add k because that is the start node and initialize the weight to be 0 since we haven't traversed the graph yet
        minHeap.add(new int[]{k, 0});
        
        // Keep track of the vertices that have already been visited so we don't traverse infinitely
        Set<Integer> visited = new HashSet<>();
        
        // Keep track of the total time it will take to reach all nodes
        int totalTime = 0;
        
        // Iterate while there are still nodes in the min heap
        while (!minHeap.isEmpty()) {
            // Extract the components of each node from the min heap
            int[] node = minHeap.remove();
            int vertex = node[0];
            int weight = node[1];
            
            // Check if the vertex has already been visited, if so, then we can just move on to the next one
            if (visited.contains(vertex)) {
                continue;
            }
            
            // Add the vertex to the visited set
            visited.add(vertex);
            
            // Update the totalTime if needed
            totalTime = Math.max(totalTime, weight);
            
            // Iterate through all destination nodes from the current vertex
            for (int[] destination : adjacencyList.get(vertex)) {
                // If we haven't visited a destination node yet, then add it to the min heap
                // For the weight, we want to calculate the cumulative weight it takes to traverse the graph, which is why we do weight + destination[1]
                if (!visited.contains(destination[0])) {
                    minHeap.add(new int[]{destination[0], weight + destination[1]});
                }
            }
        }

        // If we were able to visit all the nodes, then return totalTime. Otherwise, return -1
        return visited.size() == n ? totalTime : -1;
    }
}
