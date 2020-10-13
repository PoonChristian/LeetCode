// LeetCode 515: Find Largest Value in Each Tree Row
// https://leetcode.com/problems/find-largest-value-in-each-tree-row/

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxValues = new ArrayList<Integer>();

        if (root == null) {
            return maxValues;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxAtLevel = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                maxAtLevel = Math.max(maxAtLevel, current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            maxValues.add(maxAtLevel);
        }

        return maxValues;
    }
}
