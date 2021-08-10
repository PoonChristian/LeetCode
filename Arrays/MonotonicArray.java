// LeetCode 896: Monotonic Array
// https://leetcode.com/problems/monotonic-array/

public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        // Keep a boolean flag for both increasing and decreasing and mark them as true
        // We want to mark them true instead of false because an array with identical values, such as [1,1,1,1] is also monotonic
        boolean increasing = true;
        boolean decreasing = true;
        
        for (int i = 0; i < nums.length - 1; i++) {
            // If at any point, the value to the right is less than the current value,
            // we know the array can't be monotonically increasing anymore
            if (nums[i] > nums[i + 1]) {
                increasing = false;
            }
            
            // If at any point, the value to the right is greater than the current value,
            // we know the array can't be monotonically decreasing anymore
            if (nums[i] < nums[i + 1]) {
                decreasing = false;
            }
        }
        
        // If either of the flags are true, then the array is monotonic in either fashion
        return increasing || decreasing;
    }
}