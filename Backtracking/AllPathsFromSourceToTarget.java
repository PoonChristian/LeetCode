// LeetCode 797: All Paths From Source to Target
// https://leetcode.com/problems/all-paths-from-source-to-target/

public class AllPathsFromSourceToTarget {
    private void backtrack(int[][] graph, List<List<Integer>> paths, List<Integer> current, int start) {
        if (start == graph.length - 1) {
            paths.add(new ArrayList<Integer>(current));
            return;
        }
        
        int[] neighbors = graph[start];
        
        for (int neighbor : neighbors) {
            current.add(neighbor);
            backtrack(graph, paths, current, neighbor);
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> allPathsSourceTargetDFS(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        current.add(0);
        backtrack(graph, paths, current, 0);
        return paths;
    }

    public List<List<Integer>> allPathsSourceTargetBFS(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        queue.offer(Arrays.asList(0));
        
        int target = graph.length - 1;
        
        while (!queue.isEmpty()) {
            List<Integer> path = queue.poll();
            int source = path.get(path.size() - 1);
            
            if (source == target) {
                paths.add(new ArrayList<Integer>(path));
            } else {
                int[] neighbors = graph[source];
                
                for (int neighbor : neighbors) {
                    List<Integer> newPath = new ArrayList<Integer>(path);
                    newPath.add(neighbor);
                    queue.offer(newPath);
                }
            }
        }
        
        return paths;
    }
}
