// LeetCode 154: Find Minimum in Rotated Sorted Array II
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

// Algorithm: Same as FindMinimumInRotatedSortedArray, except one condition is added to handle duplicates
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                // If there's a duplicate, then decrement right by 1, so then we can set a new mid in the next iteration
                right--;
            }
        }
        
        return nums[left];
    }
}
