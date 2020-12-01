public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        // Initialize variables to track the length of the longest subsequence of number of longest subsequences
        int longest = 0;
        int numLongest = 0;

        // Initialize dp arrays to store values of subproblems
        // counts[index] = the number of longest subsequences from 0 to index
        // lengths[index] = the length of the longest subsequence from 0 to index
        int[] counts = new int[nums.length];
        int[] lengths = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            // At every index, the longest increasing subsequence is the value itself
            // Therefore, initialize counts[i] and lengths[i] to 1
            counts[i] = 1;
            lengths[i] = 1;
            
            // Iterate from the beginning of the array up until i
            for (int j = 0; j < i; j++) {
                // The subsequence must be strictly increasing, so we only consider if nums[j] is less than nums[i]
                if (nums[j] < nums[i]) {
                    /*  
                      Two Cases:
                        1. lengths[i] < lengths[j] + 1
                         - lengths[j] + 1 is the length of the subsequence if we include nums[i]
                         - Therefore, if the length of the subsequence from 0 to j that includes nums[i], is greater than the longest subsequence we've found thus far (lengths[i])
                         - Then we want to set lengths[i] equal to the length of the new subsequence lengths[j] + 1
                         - We also want to set counts[i] equal to counts[j] because we know that we can have as many subsequences as there were at counts[j]
                        
                         2. lengths[i] == lengths[j] + 1
                         - This case means that there's another subsequence from 0 to j that includes nums[i], that has the same length as the longest subsequence we've found thus far (lengths[i])
                         - Therefore, we want to increment counts[i] by counts[j] in order to account for all the previous subsequences
                    */
                    if (lengths[i] < lengths[j] + 1) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[i] == lengths[j] + 1) {
                        counts[i] += counts[j];
                    }
                }
            }
            
            /*
                If our longest variable is equal to the length of the longest subsequence up to i:
                    Then add the count of longest subsequences up to i to the numLongest variable
                Otherwise, if the longest variable is less than length of the longest subsequence up to i:
                    Then set the longest variable equal to the length of the longest subsequence up to i and set numLongest equal to the count of longest subsequences up to i
            */
            if (longest == lengths[i]) {
                numLongest += counts[i];
            } else if (longest < lengths[i]) {
                longest = lengths[i];
                numLongest = counts[i];
            }
        }
        
        // Return the numLongest variable
        return numLongest;
    }
}
