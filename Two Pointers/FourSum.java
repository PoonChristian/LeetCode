// LeetCode 18: 4Sum
// https://leetcode.com/problems/4sum/

// Algorithm: Same thing as 3Sum, except there is an additional loop
// Time Complexity: O(n^3) 
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        
        Arrays.sort(nums);
        int length = nums.length;
        
        for (int i = 0; i < length - 3; i++) {
            // This if statement ensures we don't count a duplicate for the first number
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < length - 2; j++) {
                    // This if statement ensures we don't count a duplicate for the second number
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        // Same steps below from three sum, except we want to count both nums[i] and nums[j]
                        int left = j + 1;
                        int right = length - 1;
                        
                        while (left < right) {
                            int sum = nums[i] + nums[j] + nums[left] + nums[right];
                            
                            if (sum == target) {
                                quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                                
                                while (left < right && nums[left] == nums[left + 1]) {
                                    left++;
                                }
                                
                                while (left < right && nums[right] == nums[right - 1]) {
                                    right--;
                                }
                                
                                left++;
                                right--;
                            } else if (sum < target) {
                                left++;
                            } else {
                                right--;
                            }
                        }
                    }
                }
            }
        }
        
        return quadruplets;
    }
}
