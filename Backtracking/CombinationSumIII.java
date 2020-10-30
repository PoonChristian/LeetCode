// LeetCode 216: Combination Sum III
// https://leetcode.com/problems/combination-sum-iii/

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        if (k > n) {
            return combinations;
        }
        backtrack(combinations, new ArrayList<Integer>(), 1, k, n);
        return combinations;
    }

    public void backtrack(List<List<Integer>> combinations, List<Integer> currentCombination, int start, int k, int n) {
        if (currentCombination.size() == k && n == 0) {
            combinations.add(new ArrayList<Integer>(currentCombination));
        } else {
            for (int i = start; i <= 9; i++) {
                if (n - i < 0) {
                    return;
                }
                currentCombination.add(i);
                backtrack(combinations, currentCombination, i + 1, k, n - i);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }
}
