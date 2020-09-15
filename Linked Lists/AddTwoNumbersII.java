// LeetCode 445: Add Two Numbers
// https://leetcode.com/problems/add-two-numbers-ii/

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummy = new ListNode(-1);
        int carry = 0;

        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int x = !s1.isEmpty() ? s1.pop() : 0;
            int y = !s2.isEmpty() ? s2.pop() : 0;
            int sum = x + y + carry;
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            node.next = dummy.next;
            dummy.next = node;
        }

        return dummy.next;
    }
}
