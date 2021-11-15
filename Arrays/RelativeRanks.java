// LeetCode 506: Relative Ranks
// https://leetcode.com/problems/relative-ranks/

public class RelativeRanks {
    private String[] medals = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};

    public String[] findRelativeRanks(int[] score) {
        // Check that we have scores to process before proceeding
        if (score == null || score.length == 0) {
            return new String[0];
        }
        
        // Create a score map and populating with key-value [score, index]
        Map<Integer, Integer> scoreMap = new HashMap<>();
        
        for (int i = 0; i < score.length; i++) {
            scoreMap.put(score[i], i);
        }
        
        // Sort the array 
        Arrays.sort(score);

        // Initialize the result array
        String[] ranks = new String[score.length];

        // Keep track of what place we are at to determine whether to give a medal 
        int place = 1;
        
        // Iterate from the end of the array to the beginning (highest scores to lowest scores)
        for (int i = score.length - 1; i >= 0; i--) {
            // If place is less than or equal to 3, then give the athlete at this index a medal
            // Provide (place - 1) to the medals array since it is zero-indexed
            // Otherwise if place is greater than 3, just assign the place number as a string
            if (place <= 3) {
                ranks[scoreMap.get(score[i])] = medals[place - 1];
            } else {
                ranks[scoreMap.get(score[i])] = String.valueOf(place);
            }
            
            // Increment place at each iteration
            place++;
        }
        
        // Return ranks array
        return ranks;
    }
}