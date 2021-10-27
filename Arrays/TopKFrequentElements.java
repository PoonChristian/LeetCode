// LeetCode 347: Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements/

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // If k is equal to nums.length, then the k most frequent elements is the array itself
        if (k == nums.length) {
            return nums;
        }
        
        // Define a HashMap to store frequencies for each element
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        
        // Iterate over the nums array and set the HashMap with key being the number and value being the frequency
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Define a min heap with a comparator that is based on the frequency of the elements from the HashMap
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> freqMap.get(a) - freqMap.get(b));
        
        // Iterate over the HashMap keys in order to populate the min heap
        for (int num : freqMap.keySet()) {
            // Add the number into the min heap
            minHeap.add(num);

            // If the size of the min heap ever goes past k, then we must remove the most infrequent element
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        
        // Define the result array and a pointer
        int[] topK = new int[k];
        int i = 0;
        
        // Populate the result array with the values in the min heap
        while (!minHeap.isEmpty()) {
            topK[i++] = minHeap.remove();
        }
        
        // Return the result array
        return topK;
    }
}
