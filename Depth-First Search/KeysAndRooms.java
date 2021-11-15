// LeetCode 841: Keys and Rooms
// https://leetcode.com/problems/keys-and-rooms/

// Algorithm: DFS to try a particular path to reach all the rooms, and use a visited array to keep track of rooms already visited
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // If there are no rooms to visit, then we can't visit any room, so I would return false
        // This is up to the interviewer how this edge case should be defined
        if (rooms == null || rooms.size() == 0) {
            return false;
        }
        
        // Keep track of the visited rooms
        boolean[] visitedRooms = new boolean[rooms.size()];
        
        // DFS and try to visit all the rooms
        dfs(rooms, visitedRooms, 0);
        
        // Iterate through the visited rooms and check if all the rooms have been visited
        for (int i = 0; i < visitedRooms.length; i++) {
            // If a room hasn't been visited, then return false
            if (!visitedRooms[i]) {
                return false;
            }
        }
        
        // If we get through this entire loop, then we know we've visited all the rooms, so return true
        return true;
    }
    
    public void dfs(List<List<Integer>> rooms, boolean[] visitedRooms, int roomIndex) {
        // If we've already visited the room, then return out
        if (visitedRooms[roomIndex]) {
            return;
        }
        
        // Otherwise, mark the room at roomIndex as visited
        visitedRooms[roomIndex] = true;
        
        // Extract the keys to the other rooms from the current roomIndex
        List<Integer> keys = rooms.get(roomIndex);
        
        // Iterate through all the keys and try them out to visit all the rooms
        for (int key = 0; key < keys.size(); key++) {
            dfs(rooms, visitedRooms, keys.get(key));
        }
    }
}
