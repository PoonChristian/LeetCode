// LeetCode 109: Convert Sorted List to Binary Search Tree
// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        return convertListToBST(head, null);
    }

    private TreeNode convertListToBST(ListNode start, ListNode end) {
        if (start == null || start == end) {
            return null;
        }

        ListNode middle = getMiddleNode(start, end);

        TreeNode root = new TreeNode(middle.val);
        root.left = convertListToBST(start, middle);
        root.right = convertListToBST(middle.next, end);

        return root;
    }

    private ListNode getMiddleNode(ListNode start, ListNode end) {
        ListNode slow = start;
        ListNode fast = start;

        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
