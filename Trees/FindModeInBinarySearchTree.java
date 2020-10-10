// LeetCode 501: Find Mode in Binary Search Tree
// https://leetcode.com/problems/find-mode-in-binary-search-tree/

public class FindModeInBinarySearchTree {
    int max = Integer.MIN_VALUE;
    Integer prev = null;
    int count = 1;

    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<Integer>();
        max = Integer.MIN_VALUE;

        inorder(root, modes);

        int[] modeArray = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            modeArray[i] = modes.get(i);
        }

        return modeArray;
    }

    private void inorder(TreeNode root, List<Integer> modes) {
        if (root == null) {
            return;
        }

        inorder(root.left, modes);

        if (prev != null) {
            if (prev == root.val) {
                count++;
            } else {
                count = 1;
            }
        }

        if (count > max) {
            max = count;
            modes.clear();
            modes.add(root.val);
        } else if (count == max) {
            modes.add(root.val);
        }

        prev = root.val;

        inorder(root.right, modes);
    }
}