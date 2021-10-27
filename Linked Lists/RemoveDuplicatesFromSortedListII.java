// LeetCode 82: Remove Duplicates from Sorted List II
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        // Initialize a dummy node whose next value points to the head
        // A dummy node is used to reduced headache with edge cases like if the head node is a duplicate node
        ListNode dummy = new ListNode(-1, head);

        // Initialize a prev pointer in order to keep track of the node prior to duplicate sublist
        ListNode prev = dummy;

        // Initialize a curr pointer to the head for traversing
        ListNode curr = head;
        
        // Iterate while curr still points to a node and it has a non-null next value
        while (curr != null && curr.next != null) {
            /* 
                Two Cases:
                1. If curr.val == curr.next.val, we must remove the duplicate sublist with pointer manipulation
                2. If curr.val != curr.next.val, we simply just move the prev pointer and curr pointers along
            */
            if (curr.val == curr.next.val) {
                // curr will point to the first occurrence of the duplicate node
                // Continuously remove the subsequent duplicate nodes with pointer manipulation and keep going until the next node is null or its value is different from the first node
                while (curr.next != null && curr.val == curr.next.val) {
                    curr.next = curr.next.next;
                }
                // At this point, curr should not be equal to curr.next
                // Simply move curr to curr.next and set prev.next equal to curr to effectively connect the linked list without the duplicates
                curr = curr.next;
                prev.next = curr;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        
        // Return dummy.next since it will point to the head of the linked list
        return dummy.next;
    }
}
