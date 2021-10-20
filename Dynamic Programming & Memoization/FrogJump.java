// LeetCode 403: Frog Jump
// https://leetcode.com/problems/frog-jump/
// Top Down and Bottom Up Solutions

public class FrogJump {
    private int canCrossRecursive(int[] stones, int[][] memo, int start, int jump) {
        // If the answer to the subproblem is already calculated, return it
        if (memo[start][jump] > -1) {
            return memo[start][jump];
        }

        // Iterate starting from the position after the current position
        for (int i = start + 1; i < stones.length; i++) {
            // The difference between stones[i] and stones[start] will be the jump range
            int nextPosition = stones[i] - stones[start];
            
            // Ensure that nextPosition is within range [jump - 1, jump + 1]
            // If so, then simulate going down this path by calling the recursive function with the new start as i and new jump as nextPosition
            // If all the conditions are true, then we know there is a possible path from position "start" with jumpsize "jump" (answer is 1)
            if (nextPosition >= jump - 1 && nextPosition <= jump + 1 && canCrossRecursive(stones, memo, i, nextPosition) == 1) {
                memo[start][jump] = 1;
                return 1;
            }
        }

        // If position start is equal to stones.length - 1, that means we've reached the end of the array, and it's possible to get there
        // Return 1 if it's possible and 0 if not and store the value in the memo array
        memo[start][jump] = start == stones.length - 1 ? 1 : 0;
        return memo[start][jump];
    }

    public boolean canCrossTopDown(int[] stones) {
        // Quick check to see if it is possible to jump from position to position
        for (int i = 3; i < stones.length; i++) {
            if (stones[i] > stones[i - 1] * 2) {
                return false;
            }
        }

        // Initialize a memo array to store results
        int[][] memo = new int[stones.length][stones.length];
        
        // Fill the memo array with -1, to denote that there is no answer yet
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        
        // Return true if the value of the recursive function is 1, false otherwise
        return canCrossRecursive(stones, memo, 0, 0) == 1;
    }

    // Bottom Up solution uses a HashMap with key-value pairs { position, Set(jump sizes that can lead to current position)}
    public boolean canCrossBottomUp(int[] stones) {
        // Quick check to see if it is possible to jump from position to position
        for (int i = 3; i < stones.length; i++) {
            if (stones[i] > stones[i - 1] * 2) {
                return false;
            }
        }

        // Initialize HashMap
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        
        // Initialize an empty set for every position in the stones array
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }

        // The only possible jump size to reach the 0th position is 0.
        map.get(0).add(0);

        // Loop over the stones array
        for (int i = 0; i < stones.length; i++) {
            // Loop over the jump sizes that can reach the current position
            for (int k : map.get(stones[i])) {
                // Check that this jump size can reach another position in the array
                // Range: [k - 1, k + 1] inclusive
                for (int jump = k - 1; jump <= k + 1; jump++) {
                    // Make sure jump is greater than 0 so we don't jump backwards
                    // Check if the stones[i] + jump reaches another point in the array (map allows O(1) access)
                    // If so, add the jump size to the corresponding position in the map
                    if (jump > 0 && map.containsKey(stones[i] + jump)) {
                        map.get(stones[i] + jump).add(jump);
                    }
                }
            }
        }

        return map.get(stones[stones.length - 1]).size() > 0;
    }

    // Depth-First Search using Stacks and HashSets
    // This solution is now "Time Limit Exceeded"
    public boolean canCrossDFS(int[] stones) {
        // Quick check to see if it is possible to jump from position to position
        for (int i = 3; i < stones.length; i++) {
            if (stones[i] > stones[i - 1] * 2) {
                return false;
            }
        }
        
        // Store all the stone positions to allow for O(1) access
        Set<Integer> stonePositions = new HashSet<Integer>();
        for (int stone : stones) {
            stonePositions.add(stone);
        }
        
        // Set the last stone to be the last value in the stones array
        int lastStone = stones[stones.length - 1];

        // Initialize 2 stacks, 1 for positions and 1 for jump distances
        // Push 0 to both stacks since 0 is the starting position and starting jump size
        Stack<Integer> positions = new Stack<Integer>();
        Stack<Integer> jumps = new Stack<Integer>();
        positions.push(0);
        jumps.push(0);
        
        // Iterate until we have no more positions to simulate jumps from
        while (!positions.isEmpty()) {
            // Pop the current position and jump distance
            int position = positions.pop();
            int jumpDistance = jumps.pop();

            // Check if there is a potential jump from the current position to another position in the array
            // Range [jumpDistance - 1, jumpDistance + 1] inclusive
            for (int i = jumpDistance - 1; i <= jumpDistance + 1; i++) {
                // Make sure that i is greater than 0 before proceeding because we don't want to jump backwards
                if (i <= 0) {
                    continue;
                }
                
                // Set nextPosition to be the current position + the current iteration's jump distance
                int nextPosition = position + i;

                // If this nextPosition is ever equal to the value of the last item in the stones array, then we've found a possible path to the end, return true
                // Otherwise if there exists a position using the current iteration's jump distance, push that position and the jump distance onto the respective stacks
                if (nextPosition == lastStone) {
                    return true;
                } else if (stonePositions.contains(nextPosition)) {
                    positions.push(nextPosition);
                    jumps.push(i);
                }
            }
        }
        
        // If we've tried all possible positions and failed to reach the last element, return false
        return false;
    }
}
