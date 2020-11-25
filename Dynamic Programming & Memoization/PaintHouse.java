// LeetCode 256: Paint House
// https://leetcode.com/problems/paint-house/

public class PaintHouse {
    private int findMinCost(int[][] costs, int[][] memo, int houseIndex, int prevColor) {
        // Base Case: If we've reached the end of the costs array, then there will be no cost, return 0
        if (houseIndex == costs.length) {
            return 0;
        }

        // Return the value of the current subproblem if we've already computed it
        if (memo[houseIndex][prevColor] != 0) {
            return memo[houseIndex][prevColor];
        }

        // Initialize a minCost variable to store the minCost available at this current house with the chosen previous color
        int minCost = Integer.MAX_VALUE;

        // Iterate through all the possible colors
        for (int color = 0; color <= 2; color++) {
            // If the current color is equal to the previous color, we can't choose it so skip it
            if (color == prevColor) {
                continue;
            }

            // minCost will be the minimum between itself and the recursive call after picking this current color
            minCost = Math.min(minCost, findMinCost(costs, memo, houseIndex + 1, color) + costs[houseIndex][color]);
        }

        // Store the value of the current subproblem and return it
        memo[houseIndex][prevColor] = minCost;
        return minCost;
    }

    public int minCostTopDown(int[][] costs) {
        // If the costs array is empty, then we should return 0
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        // Initialize an n x 4 memo array (4 is to account for previous color being empty)
        int[][] memo = new int[costs.length][4];

        // Call the recursive function starting at the first house and with a previous color of 3 (in other words, no previous color)
        return findMinCost(costs, memo, 0, 3);
    }

    public int minCostBottomUp(int[][] costs) {
        // If the costs array is empty, then we should return 0
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        // Initialize an n x 3 dp array 
        int[][] dp = new int[costs.length][3];

        // Initialize the first row of the dp array to the corresponding cells in the costs array
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        // Iterate over the costs array starting from the first index
        for (int i = 1; i < costs.length; i++) {
            // The cost of painting the current house red is the cost of painting it red plus the minimum between painting the previous house blue or green
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);

            // The cost of painting the current house blue is the cost of painting it blue plus the minimum between painting the previous house red or green
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);

            // The cost of painting the current house green is the cost of painting it green plus the minimum between painting the previous house red or blue
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        // Return the minimum between the columns in the last row after calculating all the costs   
        return Math.min(dp[costs.length - 1][0], Math.min(dp[costs.length - 1][1], dp[costs.length - 1][2]));
    }
}
