// LeetCode 872: Leaf-Similar Trees
// https://leetcode.com/problems/leaf-similar-trees/

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<Integer>();
        List<Integer> leaves2 = new ArrayList<Integer>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private void dfs(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            leaves.add(root.val);
        } else {
            dfs(root.left, leaves);
            dfs(root.right, leaves);
        }
    }
}
