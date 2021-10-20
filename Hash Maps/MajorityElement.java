// LeetCode 169: Majority Element
// https://leetcode.com/problems/majority-element/

public class MajorityElement {
    public int majorityElementHashMap(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
            if (counts.get(num) > n / 2) {
                return num;
            }
        }
        
        return -1;
    }

    // Premise: If it's guaranteed that there's a majority element, then that majority element's count will exhaust the other elements
    // Time: O(n), Space: O(1)
    public int majorityElementBoyerMoore(int[] nums) {
        // Initialize the majority as the first element to begin the algorithm
        int majority = nums[0];

        // Initialize a count to keep track of the majority element's count
        int count = 0;
        
        // Iterate over all elements
        for (int num : nums) {
            // If the current element is equal to the majority element, then increment the count
            if (num == majority) {
                count++;
            } else {
                // Otherwise, decrement the count
                count--;

                // If the count ever hits 0, then set the majority element to be the current num and set the new count to be 1
                if (count == 0) {
                    majority = num;
                    count = 1;
                }
            }
        }
        
        // The end result will be the majority element
        return majority;
    }
}