// LeetCode 162: Find Peak Element
// https://leetcode.com/problems/find-peak-element/

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;

            // We know that there is a peak if the number after mid is greater
            // Reason: The peak could possibly be greater than nums[mid + 1] or nums[mid + 1] itself
            // We can set left to mid + 1 and not consider the current mid
            // If nums[mid + 1] is not greater, than set right equal to mid because mid itself could possibly be a peak
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        // Return left once the binary search is complete
        return left;
    }
}