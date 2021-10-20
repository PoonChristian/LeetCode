// LeetCode 23: Merge k Sorted Lists
// https://leetcode.com/problems/merge-k-sorted-lists/

public class MergeKSortedLists {
    // Define a comparator for the min heap
    public class ListComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode l1, ListNode l2) {
            if (l1.val < l2.val) {
                return -1;
            } else if (l1.val > l2.val) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // If there are no lists, then just return null
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Define a min heap using the ListComparator in order to sort the ListNodes by
        // lowest value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, new ListComparator());

        // Iterate over all list nodes and add them to the min heap if they are not null
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.add(lists[i]);
            }
        }

        // Initialized a dummy and head node
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        // Iterate while the min heap still has values to process
        while (!minHeap.isEmpty()) {
            // Dequeue the ListNode that will have the lowest value
            ListNode curr = minHeap.remove();
            // Set the dummy's next pointer to that list node
            dummy.next = curr;
            // Move the dummy to its next pointer
            dummy = dummy.next;

            // If the dequeued ListNode has a non-null next pointer, then add it to the min
            // heap
            if (curr.next != null) {
                minHeap.add(curr.next);
            }
        }

        // head.next will point to the first node in the newly merged list
        return head.next;
    }
}
