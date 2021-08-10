// LeetCode 922. Sort Array by Parity II
// https://leetcode.com/problems/sort-array-by-parity-ii/

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        int evenPtr = 0;
        int oddPtr = 1;
        
        int n = nums.length;
        
        while (evenPtr < n && oddPtr < n) {
            while (evenPtr < n && nums[evenPtr] % 2 == 0) {
                evenPtr += 2;
            }
            
            while (evenPtr < n && nums[oddPtr] % 2 == 1) {
                oddPtr += 2;
            }
            
            if (evenPtr < n && oddPtr < n) {
                swap(nums, evenPtr, oddPtr);
            }
        }
        
        return nums;
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}