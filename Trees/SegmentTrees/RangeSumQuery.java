// LeetCode 307: Range Sum Query - Mutable
// https://leetcode.com/problems/range-sum-query-mutable/

/* 
    Data Structure: Segment Tree
    
    Why use a segment tree?
        Because it is efficient in that it requires O(log n) time to query or update over a range of elements

        In the context of this question, if we query the range sum between L-R over an array, the time complexity to get the range sum is O(len(R - L)), which could at worse be O(n)
        For m queries, this approach would take O(mn) time
        
        With a segment tree, the range sum query would be O(m log n) where m is the number of queries and n is the number of elements in the tree

    Time Complexity:
        1. Build Tree - O(n)
        2. Query - O(log n)
        3. Update - O(log n)

    Space Complexity:
        O(n) where n is the number of elements in the segment tree
        Note that the segment tree will be as big as (2 * nextPowerOf2 - 1)
*/

public class RangeSumQuery {
    private int[] segmentTree;
    private int n;

    public NumArray(int[] nums) {
        n = nums.length;
        // The size of the segment tree should be (2 * nextPowerOf2 - 1)
        int nextPowerOf2 = nextPowerOf2(n);
        segmentTree = new int[2 * nextPowerOf2 - 1];
        buildSegmentTree(nums, 0, n - 1, 0);
    }
    
    public void update(int index, int val) {
        rangeSumUpdate(0, n - 1, index, val, 0);
    }
    
    public int sumRange(int left, int right) {
        return rangeSumQuery(0, n - 1, left, right, 0);
    }
    
    // https://stackoverflow.com/questions/4678333/n-n-1-what-does-this-expression-do
    private int nextPowerOf2(int n){
        // If n is 0, then the next power of 2 is 1 because 2^0
        if (n == 0) {
            return 1;
        }

        // If n is greater than 0 and n & (n - 1) is 0, that means it's a power of 2, so return n
        // Visit the above StackOverflow link to understand what n & (n - 1) does
        if (n > 0 && (n & (n - 1)) == 0) {
            return n;
        }

        // While n & (n - 1) is greater than 0, then set n equal to the result of n & (n - 1)
        while ((n & (n - 1)) > 0) {
            n = n & (n - 1);
        }

        // Once the above loop breaks, it means n is at the power of two lower than its original value
        // Therefore, left shift it by 1 to get the next power of two and return
        return n << 1;
    }
    
    // Helper function to build the segment tree
    private void buildSegmentTree(int[] nums, int left, int right, int pos) {
        // If left is equal to right, that means we are at a leaf node
        // Set the leaf node to be the nums[left]
        if (left == right) {
            segmentTree[pos] = nums[left];
        } else {
            // Otherwise, get the middle of the tree
            int mid = left + (right - left) / 2;
            
            // Traverse to the left of the tree by setting the bounds [left, mid] and updating the pos to (2 * pos + 1), which represents the left child
            buildSegmentTree(nums, left, mid, 2 * pos + 1);

            // Traverse to the right of the tree by setting the bounds [mid + 1, right] and updating the pos to (2 * pos + 2), which represents the right child
            buildSegmentTree(nums, mid + 1, right, 2 * pos + 2);

            // Set the value of the parent (pos) to be the sum of its children
            segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
        }
    }
    
    // Check for overlaps between bounds to determine how far to traverse down the tree
    private int rangeSumQuery(int left, int right, int qLeft, int qRight, int pos) {
        /*  Total overlap means that the query bounds [qLeft, qRight] completely cover the bounds at the current node [left, right].
            In other words, [left, right] is completely inside [qLeft, qRight]
          qLeft                 qRight
            |                     |
                |            |
              left          right

            So return the value at the current pos since we don't need to check any further down the tree
         */
        if (qLeft <= left && qRight >= right) { 
            return segmentTree[pos];
        } else if (qLeft > right || qRight < left) {
            /*  No overlap means that the query bounds [qLeft, qRight] completely fall outside of the bounds at the current node [left, right]
                In other words, [left, right] is either too far to the right or too far to the left of [qLeft, qRight]
                         qLeft      qRight
                           |           |
                |      |                    |       |
              left1  right1               left2   right2

                So return 0 since this segment provides no value to us
            */
            return 0;
        } else {
            /*  Partial overlap means the query bounds [qLeft, qRight] cover only part of the bounds at the current node [left, right]
                
                    qLeft      qRight
                    |            |
                |     |        |       |
              left1  right1   left2   right2

                So continue traversing through the segment tree to find the nearest range sum within the query bounds
            */

            // Get the mid
            int mid = left + (right - left) / 2;

            // First value will be at the left of the tree
            int firstVal = rangeSumQuery(left, mid, qLeft, qRight, 2 * pos + 1);

            // Second value will be at the right of the tree
            int secondVal = rangeSumQuery(mid + 1, right, qLeft, qRight, 2 * pos + 2);

            // Return the sum of both values
            return firstVal + secondVal;
        }
    }
    
    // Update the value at the segment tree and its ancestors
    private void rangeSumUpdate(int left, int right, int index, int val, int pos) {
        // If the index is less than left or greater than right, that means it is not within the current segment, so just return
        if (index < left || index > right) {
            return;
        } else if (left == right) {
            // If left is equal to right, that means we've reached the leaf node that needs to be updated
            // Set the value at segmentTree[pos] = val
            segmentTree[pos] = val;
        } else {
            // Get the middle of the tree
            int mid = left + (right - left) / 2;
            
            // Traverse to the left
            rangeSumUpdate(left, mid, index, val, 2 * pos + 1);

            // Traverse to the right
            rangeSumUpdate(mid + 1, right, index, val, 2 * pos + 2);

            // Update the parent with the new sum after the update
            segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
        }
    }
}
