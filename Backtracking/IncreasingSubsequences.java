// LeetCode 491: Increasing Subsequences
// https://leetcode.com/problems/increasing-subsequences/

public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        // Initialize a set to store the increasing subsequences
        // Why a set? Because a set easily handles duplicates
        Set<List<Integer>> subsequences = new HashSet<>();

        // Call backtrack helper function to fill the subsequences HashSet
        backtrack(nums, 0, subsequences, new ArrayList<>());

        // Return the subsequences as an ArrayList
        return new ArrayList<>(subsequences);
    }
    
    private void backtrack(int[] nums, int index, Set<List<Integer>> subsequences, List<Integer> current) {
        // If our current list has more than 2 values, then we must add it to our set
        // This is the only if-base condition we need because the for-loop below covers the base case where index must be less than nums.length
        if (current.size() >= 2) {
            subsequences.add(new ArrayList<>(current));
        }
        
        // Iterate from the current index until the end of nums.length
        for (int i = index; i < nums.length; i++) {
            // Either of these two conditions must be true if we want to add a number to the current list
            // 1. The current list is empty
            // 2. The last value of the current list is less than or equal to nums[i]
            if (current.isEmpty() || current.get(current.size() - 1) <= nums[i]) {
                // Add the number
                current.add(nums[i]);

                // Advance i forward in our next recursive call and find more increasing subsequences
                backtrack(nums, i + 1, subsequences, current);

                // Remove the number we just added to consider a new subsequence
                current.remove(current.size() - 1);
            }
        }
    }
}