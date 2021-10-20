// LeetCode 297: Serialize and Deserialize Binary Tree
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

public class SerializeandDeserializeBinaryTree {
    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode
     * left; TreeNode right; TreeNode(int x) { val = x; } }
     */
    class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            // If root is null, then we want to set a character to represent a null node, like "X." Add a comma as a delimiter
            if (root == null) {
                return "X,";
            }

            // Recurse through the current node's children and serialize each node
            String leftSerialize = serialize(root.left);
            String rightSerialize = serialize(root.right);

            // Return the value of the current node and delimit it with its left and right children's serializations
            // The serialization will be a preorder representation
            // Ex: [1,2,3,null,null,4,5] --> 1,2,X,X,3,4,X,X,5,X,X
            return root.val + "," + leftSerialize + rightSerialize;

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            // Use a queue to deserialize from top to bottom
            Queue<String> nodes = new LinkedList<String>();
            // Add all the nodes from the data string to the queue
            nodes.addAll(Arrays.asList(data.split(",")));
            // Call a helper function to go through the queue of nodes
            return deserializeHelper(nodes);
        }

        public TreeNode deserializeHelper(Queue<String> nodes) {
            // Get the value of the node at the beginning of the queue
            String nodeVal = nodes.remove();

            // If the node is "X", then it is a null node, so return null
            if (nodeVal.equals("X")) {
                return null;
            }

            // Parse the value of the node into an integer and then create a new TreeNode from it
            TreeNode newNode = new TreeNode(Integer.parseInt(nodeVal));
            // Set the new node's left and right to be the recursive calls of the deserializeHelper function in the same order as when serialized
            newNode.left = deserializeHelper(nodes);
            newNode.right = deserializeHelper(nodes);

            // Return the deserialization of the tree
            return newNode;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
}