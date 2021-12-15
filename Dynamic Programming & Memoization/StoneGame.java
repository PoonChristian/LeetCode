// LeetCode 877: Stone Game
// https://leetcode.com/problems/stone-game/

// Algorithm: Exact same logic as Predict The Winner (LeetCode 486: https://leetcode.com/problems/predict-the-winner/)
public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int[][] memo = new int[piles.length][piles.length];
        return score(piles, 0, piles.length - 1, memo) > 0;
    }
    
    private int score(int[] piles, int start, int end, int[][] memo) {
        // If start reaches the end, then just return the number at that index
        if (start == end) {
            return piles[start];
        }
        
        // If the answer for the subarray from start to end has already been computed, then return it
        if (memo[start][end] != 0) {
            return memo[start][end];
        }
        
        // a represents the score if the player picks the left value
        // In the recursive call, increment start by 1 since we used nums[start], then subtract it from nums[start]
        /* 
        Why subtract?
            Because player1 and player2 are competing against each other
            Once player1 takes piles[start], then we want to subtract the most optimal score player2 can get
            after player1 makes this decision because the scores offset each other through subtraction.
            This is because the answer to the recursive call could be either positive (player1 wins) or negative (player2 wins)
            Same logic applies for when player2 takes piles[start].
            If a is zero or positive, then we know player1 won for the current subarray. However if a is negative, then we know player2 won
        */
        int a = piles[start] - score(piles, start + 1, end, memo);

        // b represents the score if the player picks the right value
        // In the recursive call, decrement end by 1 since we used piles[end], then subtract it from [o;es][end]
        // See above explanation for why we use subtraction
        int b = piles[end] - score(piles, start, end - 1, memo);
        
        // Store the result of the subarray from start to end into memo. We want the max in order to get the highest score that a player can get for this subarray
        memo[start][end] = Math.max(a, b);
        
        // Return the result
        return memo[start][end];
    }
}
