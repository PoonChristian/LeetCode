// LeetCode 784: Letter Case Permutation
// https://leetcode.com/problems/letter-case-permutation/

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        // Initialize result list
        List<String> permutations = new ArrayList<String>();

        // Add S into the list since it will always be in the result
        permutations.add(S);

        // Call recursive function that will backtrack to generate all permutations
        generatePermutations(S.toCharArray(), permutations, 0);

        // Return the result list
        return permutations;
    }

    public void generatePermutations(char[] s, List<String> permutations, int index) {
        // Base case: Return out if the index is out of bounds
        if (index >= s.length) {
            return;
        }

        // If the character at the current index is a letter:
        // 1. Change its case
        // 2. Add the new string into the result list
        // 3. Call the recursive function with this new string and move onto next index
        // 4. Revert back to its original case
        if (Character.isLetter(s[index])) {
            s[index] = toggleCase(s[index]);
            permutations.add(new String(s));
            generatePermutations(s, permutations, index + 1);
            s[index] = toggleCase(s[index]);
        }

        // Call the recursive function with the original string and move onto next index
        generatePermutations(s, permutations, index + 1);
    }

    // Helper function to convert character case easily
    private char toggleCase(char c) {
        if (Character.isUpperCase(c)) {
            return Character.toLowerCase(c);
        } else {
            return Character.toUpperCase(c);
        }
    }
}