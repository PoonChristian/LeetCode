// LeetCode 78: Subsets
// https://leetcode.com/problems/subsets/

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<List<Integer>>();
        backtrack(nums, powerSet, new ArrayList<Integer>(), 0);
        return powerSet;
    }
    
    public void backtrack(int[] nums, List<List<Integer>> powerSet, List<Integer> current, int index) {
        powerSet.add(new ArrayList<Integer>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, powerSet, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
