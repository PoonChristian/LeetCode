public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // If m and n are equal, then no reversal is required
        if (m == n) {
            return head;
        }

        // Set a dummy node to prevent NullPointerException in the future (if m == 1)
        ListNode beforeReverse = new ListNode(-1);
        beforeReverse.next = head;

        // Advance curr to the position where the reversal starts
        ListNode curr = head;
        int i = 1;
        while (i < m) {
            beforeReverse = curr;
            curr = curr.next;
            i++;
        }

        // Perform the reversal until i reaches n
        ListNode prev = beforeReverse;
        while (i <= n) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        // Set the tail node's next value to the node that curr points at after reversal
        beforeReverse.next.next = curr;
        // Set the beforeReverse node's next value to prev, since prev is the head of
        // the reversed list
        beforeReverse.next = prev;

        // if m == 1, the new head will be pointing at prev
        // otherwise, just return the original head
        if (m == 1) {
            return prev;
        } else {
            return head;
        }
    }
}
