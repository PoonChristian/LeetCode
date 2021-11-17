// LeetCode 15: 3Sum
// https://leetcode.com/problems/3sum/

// Time Complexity: O(n^2)
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort nums first
        Arrays.sort(nums);
        
        // Initialize the triplets list
        List<List<Integer>> triplets = new ArrayList<>();
        
        // Iterate until the second to last character of nums because we only care about triplets
        for (int i = 0; i < nums.length - 2; i++) {
            // If i is at the beginning or nums[i - 1] is not a duplicate of nums[i], then we can proceed to find triplet
            if (i == 0 || nums[i] != nums[i - 1]) {
                // We have 3 variables a, b, and c.
                // Assume a = nums[i], and we are looking for b and c
                // Since the target is 0, the equation is a + b + c = 0
                // Since we have our a, we can subtract it from 0 to get b + c = -a
                // Now all we have to do is solve for b and c whose sum is equal to -a
                int target = 0 - nums[i];
                
                // Initialize the left pointer to be i + 1 and the right pointer to be nums.length - 1
                int left = i + 1;
                int right = nums.length - 1;

                // Below is the two pointer algorithm used to solve Two Sum II with sorted arrays
                while (left < right) {
                    int twoSum = nums[left] + nums[right];

                    if (twoSum == target) {
                        // Utilize Arrays.asList to easily add the triplet to the triplets list
                        triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // Once we use nums[left] in this iteration, we can't use it anymore, so increment left until we're at the last instance of nums[left]
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        // Once we use nums[right] in this iteration, we can't use it anymore, so decrement right until we're at the last instance of nums[right]
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        // Increment left and decrement right
                        left++;
                        right--;
                    } else if (twoSum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return triplets;
    }
}
