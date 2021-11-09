// LeetCode 287: Find the Duplicate Number
// https://leetcode.com/problems/find-the-duplicate-number/

// Algorithm: Floyd's Cycle Detection
// This problem is similar to Linked List Cycle II. It is a linked list problem masked with an array input
// See the following video for a concise explanation: https://youtu.be/wjYnzkAhcNk
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {        
        // Initialize a slow and fast pointer
        int slow = nums[0];
        int fast = nums[0];
        
        // Use a do-while loop in order to iterate at least once since the slow and fast pointers start out equal
        do {
            // Move the slow pointer to its next valu
            slow = nums[slow];

            // Move the fast pointer to its next-next value
            fast = nums[nums[fast]];

            // Note that the above operations will work since the values in the array are between the range [1,n] inclusive
            // This do-while loop will break once the slow and fast pointers intersect
        } while (slow != fast);
        
        // Set a new pointer at the beginning of the list
        int newSlow = nums[0];
        
        // Iterate until the slow pointer and new pointer have not met
        // We use while loop instead of do-while loop because the first value in the array can potentially be where the cycle begins
        while (slow != newSlow){
            slow = nums[slow];
            newSlow = nums[newSlow];
        }
        
        // The value that the slow pointer is pointing at is the duplicate
        return slow;
    }
}
