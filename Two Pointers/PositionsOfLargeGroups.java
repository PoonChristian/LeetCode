// LeetCode 830: Positions of Large Groups
// https://leetcode.com/problems/positions-of-large-groups/

// Algorithm: Use a sliding window to see how long the same character intervals are. If they're greater than or equal to 3, then add them to the final result
public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> intervals = new ArrayList<>();
        int i = 0;
        
        for (int j = 0; j < s.length(); j++) {
            // If j is at the last character of the string or if the character at j is not the same as the character at j + 1
            if (j == s.length() - 1 || s.charAt(j) != s.charAt(j + 1)) {
                // Check the group size before adding. We add 1 to j - i to get the true length of the group, but add interval [i, j] to the final result
                if (j - i + 1 >= 3) {
                    intervals.add(Arrays.asList(i, j));
                }
                
                // Move i to j + 1 to start checking the next interval
                i = j + 1;
            }
        }
        
        return intervals;
    }
}
