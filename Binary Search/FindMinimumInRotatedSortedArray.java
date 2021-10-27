// LeetCode 153: Find Minimum in Rotated Sorted Array
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        // Perform a modified binary search in order to find the pivot, the smallest value in the array, to determine where the array got rotated
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            // If the number at the midpoint is greater than the rightmost element, then the smallest value must be to the right of the midpoint
            // Ex: [4, 5, 6, 7, 0, 1, 2]
            //        mid = 7, right = 2,
            //        7 > 2, so left = 0 and the search is reduced to [0, 1, 2]
            // In the other case, then the smallest value must be the midpoint itself or somewhere to the left of it, so set right equal to mid
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        // Once the above loop breaks, the left pointer will point to the minimum, so return the value at that index
        return nums[left];
    }
}
