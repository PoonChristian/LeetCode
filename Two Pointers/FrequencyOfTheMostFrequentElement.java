// LeetCode 1838: Frequency of the Most Frequent Element
// https://leetcode.com/problems/frequency-of-the-most-frequent-element/
// Video Explanation: https://youtu.be/vgBrQ0NM5vE

public class FrequencyOfTheMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        
        int left = 0;
        int right = 0;
        // Note: We define total as a long to deal with large inputs in the array and provide int overflow
        long total = 0;
        int maxWindow = 0;
        
        while (right < nums.length) {
            total += nums[right];
            
            // nums[right] * (right - left + 1) is the total number of moves needed to make all numbers in the window equal to nums[right]
            // total + k is the number of moves we CAN make, given that k is our "budget"
            // If we can't make enough moves, then we must decrement nums[left] from the total and move our left pointer forward
            while (nums[right] * (right - left + 1) > total + k) {
                total -= nums[left];
                left++;
            }
            
            maxWindow = Math.max(maxWindow, right - left + 1);
            
            right++;
        }
        
        return maxWindow;
    }
}
