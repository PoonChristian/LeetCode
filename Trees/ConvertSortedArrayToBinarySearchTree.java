// LeetCode 108: Convert Sorted Array to Binary Search Tree
// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return convertArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode convertArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = convertArrayToBST(nums, left, mid - 1);
        node.right = convertArrayToBST(nums, mid + 1, right);
        return node;
    }
}