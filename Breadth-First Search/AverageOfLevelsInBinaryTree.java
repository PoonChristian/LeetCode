// LeetCode 637: Average of Levels in Binary Tree
// https://leetcode.com/problems/average-of-levels-in-binary-tree/

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<Double>();

        if (root == null) {
            return averages;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                sum += curr.val;

                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            averages.add(sum / size);
        }

        return averages;
    }
}