// LeetCode 448: Find All Numbers Disappeared in an Array
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

// Algorithm: Since all values in nums is between the range [1,n] inclusive, change existing numbers corresponding to indices to negative if they're seen in the array
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // First loop will flip numbers corresponding to the indices from negative to positive
        for (int i = 0; i < nums.length; i++) {
            // The index will be the absolute value of nums[i] - 1
            // Subtract 1 since arrays have zero-based indexing
            // We know this will work since nums[i] is in the range [1,n] inclusive
            int index = Math.abs(nums[i]) - 1;
            
            // If the value at the index is still positive, then turn it into a negative
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        
        // Initialize the result ArrayList
        List<Integer> missingNumbers = new ArrayList<>();
        
        // Second loop will look for remaining positive numbers and add their indices to the ArrayList
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                // Add i + 1 to the ArrayList since the positive value is at the zero-based index and we want the one-based number corresponding to that index
                missingNumbers.add(i + 1);
            }
        }
        
        // Return the ArrayList
        return missingNumbers;
    }
}
