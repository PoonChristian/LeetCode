// LeetCode 729: My Calendar I
// https://leetcode.com/problems/my-calendar-i/

// Object-Oriented Design: Segment Tree, where each node represents an interval with a start and an end
public class MyCalendarI {
    // Every SegmentTreeNode will have a start, an end, a left pointer, and a right pointer
    class SegmentTreeNode {
        int start;
        int end;
        SegmentTreeNode left;
        SegmentTreeNode right;
        
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    // Define the segment tree root and a flag to check if we find an opening in the calendar
    SegmentTreeNode root;
    boolean foundOpening;

    public MyCalendar() {
        // Set foundOpening equal to false to start out
        // This flag will only be momentarily true once we find a path to the bottom of the tree, representing an opening in the calendar
        foundOpening = false;
    }
    
    public boolean book(int start, int end) {
        // Validate the interval before proceeding to book
        if (end < start || start < 0) {
            return false;
        }
        
        // Call the helper function to traverse the segment tree and find a path to the bottom (i.e. find an opening in the calendar)
        // This will set the root of the tree if there is no root, and then will always return this root in the end, but it will still traverse the tree and create new child nodes along the way
        root = insertSegmentTreeNode(root, start, end);
        
        // foundOpening will be set to true if there was an open path to the bottom
        // If it's true, set it back to false to restart the process, and then return true to denote that it is possible to book [start, end]
        // Otherwise, return false
        if (foundOpening) {
            foundOpening = false;
            return true;
        } else {
            return false;
        }
    }
    
    // Helper function that traverses the segment tree to make sure the [start, end] is a valid interval to book
    public SegmentTreeNode insertSegmentTreeNode(SegmentTreeNode root, int start, int end) {
        // If root is null, that means we've reached the bottom of the tree and found an opening in the calendar
        // Set foundOpening to true and return a new SegmentTreeNode with the start and end
        if (root == null) {
            foundOpening = true;
            return new SegmentTreeNode(start, end);
        }
        
        // If the current node's start value is greater than the end, that means that the interval can potentially be booked somewhere to the left of the current node
        // Otherwise if the current node's end value is less than the start, that means that the interval can potentially be booked somewhere to the right of the current node
        if (root.start >= end) {
            root.left = insertSegmentTreeNode(root.left, start, end);
        } else if (root.end <= start) {
            root.right = insertSegmentTreeNode(root.right, start, end);
        }
        
        // If none of the above cases hit, then we don't set any new children and we just return the root
        // If they do hit, then we still return the root, which will have references to the newly created children
        return root;
    }
}
