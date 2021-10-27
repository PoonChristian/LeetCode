// LeetCode 33: Search in Rotated Sorted Array
// https://leetcode.com/problems/search-in-rotated-sorted-array/
// Based on the following solution video by Nick White: https://youtu.be/QdVrY3stDD4

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        // Return -1 immediately if the nums array is null or empty
        if (nums == null || nums.length == 0) {
            return -1;
        }
    
        // Get the minimum index of the nums array
        int pivot = findMin(nums);

        // Initialize the left and right pointers
        int left = 0;
        int right = nums.length - 1;
        
        // Determine where in the array to search
        // The conditional statement asks if the target is between the pivot point and the rightmost element
        // Ex 1: [4, 5, 6, 7, 0, 1, 2], target = 1
        //          2 >= 0 && 2 <= 2 is true, so we will search on [0, 1, 2] by setting left equal to the pivot 0
        // Ex 2: [4, 5, 6, 7, 0, 1, 2], target = 6
        //          6 >= 0 && 6 <= 2 is false, so we will search on [4,5,6,7] by setting right equal to the value before the pivot 7
        if (target >= nums[pivot] && target <= nums[right]) {
            left = pivot;
        } else {
            right = pivot - 1;
        }
        
        // Perform a regular binary search, given our new left and right bounds
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }

    // See FindMinimumInRotatedSortedArray.java in the Binary Search directory for code explanation
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
