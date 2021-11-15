// LeetCode 951: Flip Equivalent Binary Trees
// https://leetcode.com/problems/flip-equivalent-binary-trees/

// Algorithm: Perform 4 recursive calls to check if the trees are the same when they are kept intact or the same if they are flipped
// Time Complexity: O(n) where n is the minimum number of nodes in either tree.
//     This is because we will only traverse as far as however many nodes the smaller tree has.
//     In the worst case, we'd traverse through every node in the normal order and the flipped order so that would be O(2n), which is still O(n)
// Space Complexity: O(n) due to the stack space required for the recursion and for the same reason as the time complexity
public class FlipEquivalentBinaryTrees {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // If the both root1 and root2 are null, then we know the tree is equivalent whether or not flipped true
        // If either are null or both are not null, but the values are not the same, then we know the tree can't be equivalent so return false
        // Otherwise, check if they are equivalent when flipped and not flipped. Return if either results are true
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        } else {
            boolean sameWithoutFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
            boolean sameWithFlip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
            return sameWithoutFlip || sameWithFlip;
        }
    }
}
