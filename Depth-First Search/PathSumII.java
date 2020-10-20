// LeetCode 113: Path Sum II
// https://leetcode.com/problems/path-sum-ii/solution/

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        List<Integer> currentPath = new ArrayList<Integer>();
        dfs(root, paths, currentPath, sum);
        return paths;
    }

    private void dfs(TreeNode root, List<List<Integer>> paths, List<Integer> currentPath, int sum) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null && sum - root.val == 0) {
            currentPath.add(root.val);
            paths.add(new ArrayList<Integer>(currentPath));
            currentPath.remove(currentPath.size() - 1);
        } else {
            currentPath.add(root.val);
            dfs(root.left, paths, currentPath, sum - root.val);
            dfs(root.right, paths, currentPath, sum - root.val);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}
