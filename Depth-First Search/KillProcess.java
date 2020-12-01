// LeetCode 582: Kill Process
// https://leetcode.com/problems/kill-process/

public class KillProcess {
    private void dfs(List<Integer> killedProcesses, Map<Integer, List<Integer>> processMap, int kill) {
        // Add the current process
        killedProcesses.add(kill);
        
        // If the process is not a key in the map, that means it doesn't have any children, so return out and stop searching
        if (!processMap.containsKey(kill)) {
            return;
        }
        
        // Iterate over the process's children and recursively call the dfs function on each child to continue searching
        for (int child : processMap.get(kill)) {
            dfs(killedProcesses, processMap, child);
        }
    }
    
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // Add all processes into a HashMap with key-value pair { parentId: list of all children }
        Map<Integer, List<Integer>> processMap = new HashMap<Integer, List<Integer>>();
        
        for (int i = 0; i < ppid.size(); i++) {
            if (!processMap.containsKey(ppid.get(i))) {
                processMap.put(ppid.get(i), new ArrayList<Integer>());
            }
            
            processMap.get(ppid.get(i)).add(pid.get(i));
        }
        
        // Initialize result list
        List<Integer> killedProcesses = new ArrayList<Integer>();
        
        // Perform a dfs starting from the kill id
        dfs(killedProcesses, processMap, kill);
        
        // Return the killed processes
        return killedProcesses;
    }
}
