// LeetCode 881: Boats to Save People
// https://leetcode.com/problems/boats-to-save-people/

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        // Sort the people array
        Arrays.sort(people);
        // Initialize a variable to store the result
        int numBoats = 0;
        // Initialize two pointers for the beginning and end of the array
        int i = 0;
        int j = people.length - 1;
        
        // Iterate while i is less than or equal to j
        // Equal is for the case that you still need to save one person
        while (i <= j) {
            // If the lightest person and the heaviest person is less than or equal to the limit, then we can increment i
            if (people[i] + people[j] <= limit) {
                i++;
            }
            // Decrement j regardless because we want to always take the heaviest person
            j--;
            // Increment numBoats regardless because we're using a boat in order to save the heaviest person (and the lightest person if they fit)
            numBoats++;
        }
        
        // Return numBoats
        return numBoats;
    }
}