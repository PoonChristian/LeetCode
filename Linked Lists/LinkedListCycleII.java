// LeetCode 142: Linked List Cycle II
// https://leetcode.com/problems/linked-list-cycle-ii/

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode ptr1 = head;
        ListNode ptr2 = getIntersection(head);

        if (ptr2 == null) {
            return null;
        }

        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }

    public ListNode getIntersection(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
