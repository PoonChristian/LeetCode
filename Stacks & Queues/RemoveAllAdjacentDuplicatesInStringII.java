// LeetCode 1209: Remove All Adjacent Duplicates in String II
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

public class RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
        // Initialize a count array to keep track of the number consecutive characters at a certain index
        int[] count = new int[s.length()];
        // Extract the char array from String s to work with
        char[] strArray = s.toCharArray();
        // Initialize a slow pointer that will backtrack k steps whenever there are k consecutive characters in the strArray
        int slow = 0;
        
        // Initialize a for loop with a fast pointer that traverses through the string in one pass
        for (int fast = 0; fast < s.length(); slow++, fast++) {
            // Set the value at the slow index to be the value at the fast index
            // This will reassign same values in the beginning before slow gets decremented, but we must do this in order to replace the duplicate values with their new values after slow gets decremented by k at some point
            strArray[slow] = strArray[fast];
            
            // If slow is equal to 0, then we are at the beginning of the array so the count must be 1
            // Otherwise if the character at the slow pointer is not the same as the character before, the count will also be 1 
            if (slow == 0 || strArray[slow] != strArray[slow - 1]) {
                count[slow] = 1;
            } else {
                // Else statement will trigger if the character at the slow pointer is the same as the one before
                // Get the count of the character at the index before and then add 1 to include the current character
                int addedCount = count[slow - 1] + 1;
                
                // If the count ever hits k, then we decrement slow by k steps to simulate removing the k duplicates
                // Note that in the next iteration of the for loop, slow gets incremented by 1, so the rest of the algorithm is back on track
                if (addedCount == k) {
                    slow -= k;
                } else {
                    // If the count has not hit k yet, then we can simply update the count at the current slow index to be the added count
                    count[slow] = addedCount;
                }
            }
        }
        
        // Return the new string from the strArray starting from index 0 and ending at index slow
        return new String(strArray, 0, slow);
    }
}