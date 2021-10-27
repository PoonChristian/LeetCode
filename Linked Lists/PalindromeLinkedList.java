// LeetCode 234: Palindrome Linked List
// https://leetcode.com/problems/palindrome-linked-list/

// Algorithm: Reverse the linked list from the middle to the end and then compare values from the first half to the second half
// Ex: 1 -> 2 -> 2 -> 1
//      Reverse of the second half 2 -> 1 = 1 -> 2
//      Compare first half 1 -> 2 to second half 1 -> 2 at each pointer until we reach the end
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        ListNode middle = getMiddle(curr);
        ListNode reversedFromMiddle = reverse(middle);
        
        // Note: Even if the linked list has an odd number of nodes, this algorithm still works because this condition disregards it
        // Ex: 1 -> 2 -> 3 -> 2 -> 1
        //  First half = 1 -> 2
        //  Second half = 3 -> 2 -> 1
        //  Reverse(3 -> 2 -> 1) = 1 -> 2 -> 3
        //  Iteration 1:
        //      1 == 1
        //  Iteration 2:
        //      2 == 2
        //  Iteration 3 does not happen because curr will point to null, so we disregard the node with value 3 in the second half
        while (curr != null && reversedFromMiddle != null) {
            if (curr.val != reversedFromMiddle.val) {
                return false;
            }
            
            curr = curr.next;
            reversedFromMiddle = reversedFromMiddle.next;
        }
        
        return true;
    }
    
    // Function to get the middle node of the linked list
    public ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    // Function to reverse a linked list given the start node head
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}