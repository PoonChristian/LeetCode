// LeetCode 314: Binary Tree Vertical Order Traversal
// https://leetcode.com/problems/binary-tree-vertical-order-traversal/

// Similar to LeetCode 987: Vertical Order Traversal of a Binary Tree, except:
// Nodes that share the same row and column are ordered left to right

public class BinaryTreeVerticalOrderTraversal {

    private class NodeWithColumn {
        TreeNode node;
        int column;

        public NodeWithColumn(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> columnValues = new ArrayList<List<Integer>>();

        if (root == null) {
            return columnValues;
        }

        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        Queue<NodeWithColumn> queue = new LinkedList<NodeWithColumn>();
        queue.offer(new NodeWithColumn(root, 0));

        int leftMostCol = 0;
        int rightMostCol = 0;

        while (!queue.isEmpty()) {
            NodeWithColumn current = queue.poll();
            TreeNode currNode = current.node;
            int currCol = current.column;

            if (!map.containsKey(currCol)) {
                map.put(currCol, new ArrayList<Integer>());
            }

            map.get(currCol).add(currNode.val);

            if (currNode.left != null) {
                queue.offer(new NodeWithColumn(currNode.left, currCol - 1));
                leftMostCol = Math.min(leftMostCol, current.column - 1);
            }

            if (current.node.right != null) {
                queue.offer(new NodeWithColumn(currNode.right, currCol + 1));
                rightMostCol = Math.max(rightMostCol, current.column + 1);
            }
        }

        for (int i = leftMostCol; i <= rightMostCol; i++) {
            columnValues.add(map.get(i));
        }

        return columnValues;
    }

}
