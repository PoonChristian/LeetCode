// LeetCode 160: Intersection of Two Linked Lists
// https://leetcode.com/problems/intersection-of-two-linked-lists/

/*
    Algorithm: Walk through the lists twice to look for the intersection
    In the first walk, go through the first list (ptr1 = ptr1.next, ptr2 = ptr2.next)
    In the second walk, go through the other list (ptr1 = headB, ptr2 = headA)
    The reason we only need to walk through the lists twice is because the len(listA) + len(listB) == len(listB) + len(listA), so the lengths of the lists will sync up once the pointers are reassigned to the opposite list
    
    Explanation: https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
*/
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Set ptr1 to headA and ptr2 to headB
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        
        // While ptr1 is not equal to ptr2, we still have to walk through the respective lists
        while (ptr1 != ptr2) {
            // If ptr1 is null, then set it to headB, otherwise move it to its next pointer
            ptr1 = ptr1 == null ? headB : ptr1.next;
            
            // If ptr2 is null, then set it to headA, otherwise move it to its next pointer
            ptr2 = ptr2 == null ? headA : ptr2.next;
        }
        
        // The while loop will break if it reaches the intersection or reaches null by the end of the second walk
        return ptr1;
    }
}
