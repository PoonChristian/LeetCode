// LeetCode 462: Minimum Moves to Equal Array Elements II
// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

/*
    Algorithm:
        1. Sort the array in ascending order,
        2. Compute the mid index of the array
        3. Sum up all the absolute differences between nums[mid] and every element in nums that is not equal to nums[mid]
           Reason: the absolute  difference between two numbers, nums1 and nums2, is equal to the number of moves it takes for num1 to equal num2 and vice versa
*/
public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        // If nums is null or its length is less than or equal to 1, then there are zero moves to make
        if (nums == null || nums.length <= 1) {
            return 0;
        } else if (nums.length == 2) {
            // If there are 2 elements in nums, then the number of moves is the absolute difference between the two
            return Math.abs(nums[0] - nums[1]);
        } else {
            // Otherwise, sort the nums array and find the middle element 
            Arrays.sort(nums);
            int moves = 0;
            int left = 0;
            int right = nums.length - 1;
            int mid = left + (right - left) / 2;
            
            // Simulate moving the elements from the outside, inwards to the middle element
            for (int i = 0; i < nums.length; i++) {
                // If nums[i] is ever equal to the mid, then we can just continue because the difference is 0 and provides no value
                if (nums[i] == nums[mid]) {
                    continue;
                } else {
                    // Take the absolute difference between nums[i] and nums[mid] to get the number of moves it would take to move nums[i] to nums[mid]
                    moves += Math.abs(nums[mid] - nums[i]);
                }
            }
            
            // Return the number of moves
            return moves;
        }
    }
}
