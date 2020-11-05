// LeetCode 881: Boats to Save People
// https://leetcode.com/problems/boats-to-save-people/

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int numBoats = 0;
        int i = 0;
        int j = people.length - 1;

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            numBoats++;
        }
        
        return numBoats;
    }
}