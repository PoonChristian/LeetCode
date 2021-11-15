// LeetCode 215: Kth Largest Element in an Array
// https://leetcode.com/problems/kth-largest-element-in-an-array/

// Time Complexity: O(n log k) where n is the number of elements in the input array k is the number of elements in the heap
// Space Complexity: O(k) where k is the number of elements in the heap
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        // Error checking for invalid input
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (k > nums.length) {
            return nums[0];
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.add(num);
            
            // Keep the heap's size at k
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        
        // By the end of the above loop, the top of the heap will hold the kth largest element
        return minHeap.peek();
    }
}
