// LeetCode 948: Bag of Tokens
// https://leetcode.com/problems/bag-of-tokens/

public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int P) {
        // Sort the array from smallest to largest
        Arrays.sort(tokens);
        // Initialize a variable to store the final score and a variable to store the current score as the game is being played
        int maxScore = 0;
        int currentScore = 0;
        // Initialize two pointers from the beginning and end of the array
        int i = 0;
        int j = tokens.length - 1;

        while (i <= j) {
            // If we have enough power for the smallest token, then take that token and add to our score
            if (power >= tokens[i]) {
                // Decrement our power by the smallest token and increment our score
                power -= tokens[i++];
                currentScore++;
                maxScore = Math.max(maxScore, currentScore);
            } else if (currentScore > 0) {
                // If our score is greater than 0, then take the largest token and add it to our power, and then decrement our score
                power += tokens[j--];
                currentScore--;
            } else {
                // If the above two cases don't hit, then we know the game is over, so just return maxScore
                return maxScore;
            }
        }
        
        // Return the score
        return maxScore;
    }
}