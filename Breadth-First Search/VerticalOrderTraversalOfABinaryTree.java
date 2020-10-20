// LeetCode 987: Vertical Order Traversal of a Binary Tree
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

// Similar to LeetCode 314: Binary Tree Vertical Order Traversal, except:
// Nodes that share the same row and column are ordered smallest to largest

public class VerticalOrderTraversalOfABinaryTree {

    int leftMostCol = 0;
    int rightMostCol = 0;

    private class RowValPair {
        int row;
        int val;

        public RowValPair(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }

    private class NodeWithRowAndColumn {
        TreeNode node;
        int row;
        int column;

        public NodeWithRowAndColumn(TreeNode node, int row, int column) {
            this.node = node;
            this.row = row;
            this.column = column;
        }
    }

    private void bfs(TreeNode root, Map<Integer, List<RowValPair>> columnMap) {
        Queue<NodeWithRowAndColumn> queue = new LinkedList<NodeWithRowAndColumn>();
        queue.offer(new NodeWithRowAndColumn(root, 0, 0));

        while (!queue.isEmpty()) {
            NodeWithRowAndColumn curr = queue.poll();
            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.column;

            if (!columnMap.containsKey(col)) {
                columnMap.put(col, new ArrayList<RowValPair>());
            }

            columnMap.get(col).add(new RowValPair(row, node.val));

            if (node.left != null) {
                queue.offer(new NodeWithRowAndColumn(node.left, row + 1, col - 1));
                leftMostCol = Math.min(leftMostCol, col - 1);
            }

            if (node.right != null) {
                queue.offer(new NodeWithRowAndColumn(node.right, row + 1, col + 1));
                rightMostCol = Math.max(rightMostCol, col + 1);
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> columnValues = new ArrayList<List<Integer>>();

        if (root == null) {
            return columnValues;
        }

        Map<Integer, List<RowValPair>> columnMap = new HashMap<>();

        bfs(root, columnMap);

        for (int i = leftMostCol; i <= rightMostCol; i++) {
            Collections.sort(columnMap.get(i), new Comparator<RowValPair>() {
                @Override
                public int compare(RowValPair p1, RowValPair p2) {
                    if (p1.row == p2.row) {
                        return p1.val - p2.val;
                    } else {
                        return p1.row - p2.row;
                    }
                }
            });

            List<Integer> sortedCols = new ArrayList<Integer>();

            for (RowValPair p : columnMap.get(i)) {
                sortedCols.add(p.val);
            }

            columnValues.add(sortedCols);
        }

        return columnValues;
    }

}
