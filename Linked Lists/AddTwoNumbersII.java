// LeetCode 445: Add Two Numbers
// https://leetcode.com/problems/add-two-numbers-ii/

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create two stacks to keep track of the node values from least significant digit to most significant digit
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        // Populate stack1 with the ListNodes in l1. The least significant digit will be at the top at the end of the loop.
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        // // Populate stack2 with the ListNodes in l2. The least significant digit will be at the top at the end of the loop.
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        // Create a dummy node to keep track of the head of the result list
        ListNode dummy = new ListNode(-1);

        // Initialize a carry whenever our digit sums are greater than or equal to 10
        int carry = 0;

        // Iterate while we still have values in either stack or a carry greater than 0
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int x = !s1.isEmpty() ? s1.pop() : 0;
            int y = !s2.isEmpty() ? s2.pop() : 0;
            int sum = x + y + carry;
            carry = sum / 10;

            // Create a new ListNode to add to our result list
            ListNode node = new ListNode(sum % 10);
            
            // Point the new ListNode's next pointer to the dummy node's next value
            node.next = dummy.next;

            // Point the dummy node's next value to the newly created ListNode
            dummy.next = node;

            /*
                Explanation: The above pointer manipulation works because the dummy node's next pointer will always point to the most significant digit.
                             We don't ever move the dummy pointer. We only set its next pointer over and over until we are done adding.
                Example:
                    l1 = 7 -> 2 -> 4 -> 3
                    l2 =      5 -> 6 -> 4
                    Ans= 7 -> 8 -> 0 -> 7

                    1st iteration:
                        3 + 4 + 0 = 7, carry = 0, remainder = 7
                        Step 1: node = 7, dummy.next = null
                        Step 2: 7 -> null
                        Step 3: -1 -> 7

                    2nd iteration (From this iteration onward, assume the next pointer of the last node in each step is null):
                        4 + 6 + 0 = 10, carry = 1, remainder = 0
                        Step 1: node = 0, dummy.next = 7
                        Step 2: 0 -> 7
                        Step 3: -1 -> 0 -> 7

                    3rd iteration:
                        2 + 5 + 1 = 8, carry = 0, remainder = 8
                        Step 1: node = 8, dummy.next = 0 -> 7
                        Step 2: 8 -> 0 -> 7
                        Step 3: -1 -> 8 -> 0 -> 7

                    4th iteration:
                        7 + 0 + 0 = 7, carry = 0, remainder = 7
                        Step 1: node = 7, dummy.next = 8 -> 0 -> 7
                        Step 2: 7 -> 8 -> 0 -> 7
                        Step 3: -1 -> 7 -> 8 -> 0 -> 7

                    Result dummy node = -1 -> 7 -> 8 -> 0 -> 7
                    Return dummy.next = 7 -> 8 -> 0 -> 7
            */
        }

        return dummy.next;
    }
}
