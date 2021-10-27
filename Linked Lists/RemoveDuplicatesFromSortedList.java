// LeetCode 83: Remove Duplicates from Sorted List
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        // Initialize a curr pointer that points to the head
        ListNode curr = head;
        
        // Iterate while curr is not null and it has a next value
        while (curr != null && curr.next != null) {
            // If the next node's value is the same as the current node's value, then point the next node to the node after the duplicate
            // Otherwise, point the current node to its next node
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        
        // Return the head
        return head;
    }
}
