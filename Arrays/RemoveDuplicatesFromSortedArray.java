// LeetCode 26: Remove Duplicates from Sorted Array
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        // Initialize an index to place non-duplicate numbers as we traverse through the array
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // There are two conditions when we want to place a number
            // 1. If its index is 0
            // 2. If its index is greater than 0 and the number before it is not equal to it
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        
        // Index will equal the length of the new array by the end of the loop
        return index;
    }
}
