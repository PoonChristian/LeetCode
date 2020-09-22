// LeetCode 19: Remove Nth Node From End of List
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null && first.next != null) {
            first = first.next;
            second = second.next;
        }

        if (second == head && first == null) {
            return head.next;
        } else {
            second.next = second.next.next;
            return head;
        }
    }
}