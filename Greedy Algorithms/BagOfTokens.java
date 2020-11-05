// LeetCode 948: Bag of Tokens
// https://leetcode.com/problems/bag-of-tokens/

public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int score = 0;
        int i = 0;
        int j = tokens.length - 1;

        while (i <= j) {
            if (tokens[i] <= P) {
                P -= tokens[i++];
                score++;
            } else if (score > 0 && i != j) {
                P += tokens[j--];
                score--;
            } else {
                i++;
            }
        }
        
        return score;
    }
}