// LeetCode 429: N-ary Tree Level Order Traversal
// https://leetcode.com/problems/n-ary-tree-level-order-traversal/

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();

        if (root == null) {
            return levels;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<Integer>();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                currentLevel.add(current.val);

                for (Node child : current.children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }

            levels.add(currentLevel);
        }

        return levels;
    }
}
