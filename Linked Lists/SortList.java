// LeetCode 148: Sort List
// https://leetcode.com/problems/sort-list/

// Algorithm: This problem implements Merge Sort top-down
// Watch the algorithm runthrough (11:05-14:38) of this video to understand how it works: https://youtu.be/alJswNJ4P3U?t=665
public class SortList {
    public ListNode sortList(ListNode head) {
        // If head is null or doesn't have a next, then we can just return the head itself
        if (head == null || head.next == null) {
            return head;
        }
        
        // Get the middle node - this will split the list under the hood, getMiddleNode() will remove the link between the node before mid and the mide node
        ListNode mid = getMiddleNode(head);

        // Sort the list on the left side
        ListNode left = sortList(head);

        // Sort the list on the right side (which would start at mid)
        ListNode right = sortList(mid);
        
        // After sorting the left side and right side, merge them together into one list
        return merge(left, right);
    }
    
    // This function is used to merge two sorted lists. Same function as in MergeTwoSortedLists.java
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            
            curr = curr.next;
        }
        
        curr.next = l1 != null ? l1 : l2;
        
        return dummy.next;
    }
    
    public ListNode getMiddleNode(ListNode head) {
        // Prev will be the node before slow
        ListNode prev = null;

        // Slow will traverse the list one node at a time
        ListNode slow = head;

        // Fast will traverse the list two nodes at a time
        ListNode fast = head;
        
        // Move all three pointers along until the fast pointer reaches the end
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Prev will point to the last node on the left side, so remove the link to the right side by setting prev.next equal to null
        prev.next = null;
        
        // Return slow, which will be the head node on the right side
        return slow;
    }
}
