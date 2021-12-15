// LeetCode 838: Push Dominoes
// https://leetcode.com/problems/push-dominoes/

public class PushDominoes {
    public String pushDominoes(String dominoes) {
        // Extract dominoes.length() into a variable n since we'll use it multiple times
        int n = dominoes.length();
        
        // Get the char array of the dominoes string
        char[] dominoesArray = dominoes.toCharArray();
        
        // Initialize a forces array to set the force at each index
        int[] forces = new int[n];
        
        // Initialize force to be 0
        int force = 0;
        
        // Iterate from left to right
        // In this loop, we want to maximize right-falling dominoes, minimize left-falling dominoes, and decrement the force for standing dominoes
        for (int i = 0; i < n; i++) {
            // When iterating towards the right, if the value is 'R', we want to set the force equal to n
            // This means that the right-falling domino could POSSIBLY knock over all dominoes to the right of it
            if (dominoesArray[i] == 'R') {
                force = n;
            } else if (dominoesArray[i] == 'L') {
                // If the value is 'L', we don't want to count left-falling dominoes, so set force equal to 0
                force = 0;
            } else {
                // Otherwise if the value is '.', then the force gets smaller by 1 as we go further to the right
                // Force gets decremented because when we iterate from right to left, this ensures the net force will balance out between the left and right sides
                // To ensure force is always positive, we set it equal to max(force - 1, 0)
                force = Math.max(force - 1, 0);
            }
            
            // Add the force to forces[i]
            forces[i] += force;
        }
        
        // Reset the force
        force = 0;
        
        // Iterate from right to left
        // In this loop, we want to maximize left-falling dominoes, minimize right-falling dominoes, and decrement the force for standing dominoes
        for (int i = n - 1; i >= 0; i--) {
            // When iterating towards the left, if the value is 'L', we want to set the force equal to n
            // This means that the left-falling domino could POSSIBLY knock over all dominoes to the right of it
            if (dominoesArray[i] == 'L') {
                force = n;
            } else if (dominoesArray[i] == 'R') {
                // If the value is 'R', we don't want to count right-falling dominoes, so set force equal to 0
                force = 0;
            } else {
                // Same logic as else statement in the first for-loop
                force = Math.max(force - 1, 0);
            }
            
            // Subtract the force to forces[i] to calculate the net force
            forces[i] -= force;
        }
        
        // Initialize a StringBuilder to store the result
        StringBuilder sb = new StringBuilder();
        
        // Iterate through the forces array
        for (int f : forces) {
            // If force is greater than 0, then we know it came from a right-falling domino, so append 'R'
            if (f > 0) {
                sb.append('R');
            } else if (f < 0) {
                // If force is less than 0, then we know it came from a left-falling domino, so append 'L'
                sb.append('L');
            } else {
                // Otherwise if the force is 0, that means the domino is still standing, so append '.'
                sb.append('.');
            }
        }
        
        // Return the string
        return sb.toString();
    }
}

/*
Example: S = "R.R...L"

Forces (left to right) = [7, 6, 7, 6, 5, 4, 0]
Forces (right to left) = [0, 0, 0, -4, -5, -6, -7]

Forces (vector addition from above 2 arrays) = [7, 6, 7, 2, 0, -2, -7]
Final answer given the above array           =  R  R  R  R  .   L   L
*/