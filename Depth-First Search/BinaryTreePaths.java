// LeetCode 257: Binary Tree Paths
// https://leetcode.com/problems/binary-tree-paths/

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        dfs(root, paths, "");
        return paths;
    }

    private void dfs(TreeNode root, List<String> paths, String currentPath) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            paths.add(currentPath + root.val);
        } else {
            dfs(root.left, paths, currentPath + root.val + "->");
            dfs(root.right, paths, currentPath + root.val + "->");
        }
    }
}
