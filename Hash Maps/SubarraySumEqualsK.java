// LeetCode 560: Subarray Sum Equals K
// https://leetcode.com/problems/subarray-sum-equals-k/

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        // Initialize count variable
        int count = 0;

        // Initialize a running sum variable
        int sum = 0;

        // Initialize HashMap to store frequencies of the running sums
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // 0 occurs once no matter what the input array is, so put it in the map
        map.put(0, 1);

        // Loop over the nums array
        for (int num : nums) {
            // Add num to the running sum
            sum += num;

            // If the map contains sum - k, then we've found a subarray with sum = k
            // Add the number of occurrences of sum - k to our count
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Add 1 to the count of the running sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        // Return the count
        return count;
    }
}
