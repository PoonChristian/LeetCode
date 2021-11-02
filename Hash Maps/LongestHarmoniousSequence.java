// LeetCode 594: Longest Harmonious Subsequence
// https://leetcode.com/problems/longest-harmonious-subsequence/

public class LongestHarmoniousSequence {
    public int findLHS(int[] nums) { 
        // Initialize a longest variable and a HashMap in order to keep track of each number and its frequency
        int longest = 0;
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        
        // Iterate over the nums array
        for (int num : nums) {
            // Put the number and add its frequency by 1 to the map
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            
            // If the map contains the key num + 1, then we know we can form a harmonious sequence since the difference will be exactly 1
            // Set longest to be the maximum between itself and the sum of the count at the current num and num + 1
            if (freqMap.containsKey(num + 1)) {
                longest = Math.max(longest, freqMap.get(num) + freqMap.get(num + 1));
            }
            
            // Same logic applies for key num - 1
            // We must check for this key as well in case it happens to have a longer harmonious sequence than num + 1
            if (freqMap.containsKey(num - 1)) {
                longest = Math.max(longest, freqMap.get(num) + freqMap.get(num - 1));
            }
        }

        // Return the length of the longest harmonious sequence
        return longest;
    }
}