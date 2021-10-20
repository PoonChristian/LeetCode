// LeetCode 219: Contains Duplicate II
// https://leetcode.com/problems/contains-duplicate-ii/

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        Set<Integer> set = new HashSet<Integer>();
        int i = 0;
        int j = 0;

        // Add first K elements to the set
        while (j <= k && j < nums.length) {
            int num = nums[j++];

            // If the num is already in the set, then we know it's within K number of elements apart
            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        while (j < nums.length) {
            // Remove leftmost element
            set.remove(nums[i++]);

            int right = nums[j++];

            // If the rightmost num is already in the set, then we know it's within K number
            // of elements apart
            if (set.contains(right)) {
                return true;
            }

            set.add(right);
        }

        return false;
    }
}
