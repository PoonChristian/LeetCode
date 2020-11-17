// LeetCode 96: Unique Binary Search Trees
// https://leetcode.com/problems/unique-binary-search-trees/
// Top Down and Bottom Up Solutions

/* 
Recurrence Relation:
    G(n): the number of unique BST for a sequence of length n.
    F(i, n): the number of unique BST, where the number i is served as the root of BST (1 <= i <= n).

    1. G(n) = sum(F(i, n)) for i in [1, n]
       G(0) = 1, G(1) = 1

    2. F(i, n) = G(i − 1) * G(n − i)

    3. G(n) = sum(G(i - 1) * G(n - i)) for i in [1, n]
*/

public class UniqueBinarySearchTrees {
    private int numTreesRecursive(int n, int[] memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        
        if (memo[n] != 0) {
            return memo[n];
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += numTreesRecursive(i - 1, memo) * numTreesRecursive(n - i, memo);
        }
        
        memo[n] = count;
        return memo[n];
    }

    public int numTreesTopDown(int n) {
        int[] memo = new int[n + 1];
        return numTreesRecursive(n, memo);
    }

    public int numTreesBottomUp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
