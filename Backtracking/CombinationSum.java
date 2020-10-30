// LeetCode 39. Combination Sum
// https://leetcode.com/problems/combination-sum/

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(combinations, new ArrayList<Integer>(), candidates, 0, target);
        return combinations;
    }

    public void backtrack(List<List<Integer>> combinations, List<Integer> currentCombination, int[] candidates,
            int index, int target) {
        if (target == 0) {
            combinations.add(new ArrayList<Integer>(currentCombination));
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (target - candidates[i] < 0) {
                    return;
                }
                currentCombination.add(candidates[i]);
                backtrack(combinations, currentCombination, candidates, i, target - candidates[i]);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }
}