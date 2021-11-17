// LeetCode 454: 4Sum II
// https://leetcode.com/problems/4sum-ii/

public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // Store the length of the arrays in a variable
        int n = nums1.length;
        
        // Create a HashMap that stores key-value pairs of sum and frequency of sum
        // { nums1[i] + nums2[j]: frequency of nums1[i] + nums2[j] }
        Map<Integer, Integer> sumMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumMap.put(nums1[i] + nums2[j], sumMap.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
        
        int numTuples = 0;
        
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                // Get the sum of nums3[k] and nums4[l]
                int sum = nums3[k] + nums4[l];
                
                // Check if nums3[k] + nums[4] offsets the sum that we have in the map to 0
                // Therefore we want to look for -sum in the map
                // The frequency at the key -sum will determine the number of tuples we can create
                numTuples += sumMap.getOrDefault(-sum, 0);
            }
        }
        
        return numTuples;
    }
}
