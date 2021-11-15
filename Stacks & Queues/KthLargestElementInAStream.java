// LeetCode 703: Kth Largest Element in a Stream
// https://leetcode.com/problems/kth-largest-element-in-a-stream/

// Time Complexity: O(n log k) where n is the number of elements in the input array k is the number of elements in the heap
// Space Complexity: O(k) where k is the number of elements in the heap
public class KthLargestElementInAStream {
    int k;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        
        // Add all numbers into the heap
        for (int num : nums) {
            minHeap.add(num);

            // Keep the heap's size at k
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        
        // Keep the heap's size at k
        while (minHeap.size() > k) {
            minHeap.remove();
        }
        
        // By the end of the above loop, the top of the heap will hold the kth largest element
        return minHeap.peek();
    }
}
