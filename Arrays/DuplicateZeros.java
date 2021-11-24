// LeetCode 1089: Duplicate Zeros
// https://leetcode.com/problems/duplicate-zeros/

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int i = 0;
        int numZeros = 0;
        
        // Count the number of zeros
        // Stop counting once the number of zeros + i is greater than arr.length
        for (i = 0; numZeros + i < arr.length; i++) {
            if (arr[i] == 0) {
                numZeros++;
            }
        }
        
        // Iterate backwards from i - 1 since that is the index of the first value to shift to the end of the array
        // Stop iterating once we have no more zeros to shift
        for (i = i - 1; numZeros > 0; i--) {
            // Before shifting at all, we must check if the index is in bounds of the array
            if (i + numZeros < arr.length) {
                arr[i + numZeros] = arr[i];
            }
            
            // If arr[i] is 0, then we decrement numZeros first and then shift. This will simulate duplicating the zero
            if (arr[i] == 0) {
                arr[i + --numZeros] = arr[i];
            }
        }
    }
}
