// LeetCode 1019: Next Greater Node In Linked List
// https://leetcode.com/problems/next-greater-node-in-linked-list/

public class NextGreaterNodeInLinkedList {
    // Create a pair class to keep track of the node and index of the node
    private class Pair {
        ListNode node;
        int index;

        public Pair(ListNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        // Initialize the length and pointer to the head
        int length = 0;
        ListNode curr = head;

        // Traverse through the linked list to get the length
        while (curr != null) {
            curr = curr.next;
            length++;
        }

        // Reset curr to head
        curr = head;

        // Initialize the output array with the length of the linked list
        int[] output = new int[length];

        // // Initialize a stack to keep track of each pair of nodes and indices
        Stack<Pair> stack = new Stack<Pair>();

        for (int i = 0; i < length; i++) {
            // While the stack is NOT empty and the value at the top node is less than the
            // value at current node, continually pop the pair off the stack and update
            // the values at those indices with the value at the current node
            while (!stack.isEmpty() && stack.peek().node.val < curr.val) {
                output[stack.pop().index] = curr.val;
            }

            // Push a new pair onto the stack to check for its next greater element
            stack.push(new Pair(curr, i));

            // Move the current pointer to its next node
            curr = curr.next;
        }

        // Return the output array
        return output;

    }
}
