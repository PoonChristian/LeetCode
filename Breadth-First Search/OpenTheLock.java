// LeetCode 752: Open the Lock
// https://leetcode.com/problems/open-the-lock/

public class OpenTheLock {
    // Each index of the lockPositions array corresponds to the value it would be if turned down or turned up
    // lockPositions[0]0] is wheel value 9 because 0 turned downward would wrap around and equal 9
    // lockPositions[2][0] is wheel value 1 because 2 turned downward would equal 1
    // lockPositions[4][1] is wheel value 5 because 4 turned upward would equal 5
    // lockPositions[9][1] is wheel value 0 because 9 turned upward would wrap around and equal 0
    private char[][] lockPositions = {
        {'9', '1'},
        {'0', '2'},
        {'1', '3'},
        {'2', '4'},
        {'3', '5'},
        {'4', '6'},
        {'5', '7'},
        {'6', '8'},
        {'7', '9'},
        {'8', '0'} 
    };
    
    public int openLock(String[] deadends, String target) {
        // We have 4 wheels on the lock by default
        int numWheels = 4;

        // The starting position of the lock is "0000"
        String start = "0000";
        
        // Create a hashset to store all visited lock states and also add the deadends in this set to exclude the deadends in our BFS
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        
        // Initialize a queue for the BFS
        Queue<String> queue = new LinkedList<>();
        
        // If visited does not contain the start state, then add it to the queue and visited to start off the BFS
        if (!visited.contains(start)) {
            queue.add(start);
            visited.add(start);
        }
        
        // Turns will be the number of turns it takes to reach our target state
        int turns = 0;
        
        // BFS continues as long as the queue has values to process
        while (!queue.isEmpty()) {
            // To BFS level by level, extract the size of the queue and iterate over the size
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                // Dequeue the lockState
                String lockState = queue.remove();
                
                // If the lockState is ever equal to the target, then return turns and stop the BFS
                if (lockState.equals(target)) {
                    return turns;
                }
                
                // Convert the lockState string to a char array to simulate turning the wheel up and down more efficiently
                char[] lockStateArray = lockState.toCharArray();
                
                // Iterate over all 4 wheels in the lock state
                for (int j = 0; j < numWheels; j++) {
                    // Store the original value of the current wheel
                    char temp = lockStateArray[j];
                    
                    // Set the wheel to its new value after turning the wheel down
                    lockStateArray[j] = lockPositions[temp - '0'][0];
                    
                    // Convert the wheel down lock state to a string
                    String turnDown = new String(lockStateArray);
                    
                    // Check if visited contains this wheel down lock state. If it doesn't, then add it the queue and visit it
                    if (!visited.contains(turnDown)) {
                        queue.add(turnDown);
                        visited.add(turnDown);
                    }
                    
                    // Set the wheel to its new value after turning the wheel up
                    lockStateArray[j] = lockPositions[temp - '0'][1];
                    
                    // Convert the wheel up lock state to a string
                    String turnUp = new String(lockStateArray);
                    
                    // Check if visited contains this wheel up lock state. If it doesn't, then add it the queue and visit it
                    if (!visited.contains(turnUp)) {
                        queue.add(turnUp);
                        visited.add(turnUp);
                    }
                    
                    // Reset the wheel back to temp and then simulate turning the rest of the wheels up or down
                    lockStateArray[j] = temp;
                }
            }
            
            // Increment turns by 1 because we've tried all possible moves with 1 turn above
            turns++;
        }
        
        // If we don't ever reach the target in the BFS, then return -1
        return -1;
    }
}
