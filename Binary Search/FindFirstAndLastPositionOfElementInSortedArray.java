// LeetCode 34: Find First and Last Position of Element in Sorted Array
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

public class FindFirstAndLastPositionOfElementInSortedArray {
    private int findFirst(int[] nums, int target) {
        int firstIndex = -1;
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target) {
                    firstIndex = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return firstIndex;
    }
    
    private int findLast(int[] nums, int target, int first) {
        int lastIndex = -1;
        int left = first;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) {
                    lastIndex = mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return lastIndex;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        if (first == -1) {
            return new int[]{-1,-1};
        }
        int last = findLast(nums, target, first);
        return new int[]{first, last};
    }
}
