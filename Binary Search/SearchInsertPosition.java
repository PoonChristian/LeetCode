// LeetCode 35: Search Insert Position
// https://leetcode.com/problems/search-insert-position/

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
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
        
        // We return left if we don't find the target because it handles all possible edge cases
        // Video Explanation: https://youtu.be/K-RYzDZkzCI?t=678
        return left;
    }
}
