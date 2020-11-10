// LeetCode 1029: Two City Scheduling
// https://leetcode.com/problems/two-city-scheduling/

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        /*
        Sort based on price A - price B (how much money do you save from flying a person to city A over city B?)

        Example: [[40,30],[300,200],[50,50],[30,60]]

             The below array represents the money lost from choosing city A over city B for each person
             i.e. person[i][0] - person[i][1]
             [10, 100, 0, -30]

             Sort the original array based on these values
             [-30, 0, 10, 100] -> [[30,60],[50,50],[40,30],[300,200]]

        3 possible scenarios for flying the person to city A over city B:
            1. Save money (difference will be negative)
            2. Lose money (difference will be positive)
            3. No loss/save (difference will be 0)

        Conclusion:
            The array will be sorted in ascending order based on how much money we save from choosing city A over city B
            This means 2 things:
                1. We should pick the price for city A for the 1st half of the array
                2. We should pick the price for city B for the 2nd half of the array
            With this in mind, we can increment our result accordingly to get the optimal cost with equal partitioning.
        */
        Arrays.sort(costs, (a,b) -> Integer.compare(a[0] - a[1], b[0] - b[1]));
        
        int cost = 0;
        int n = costs.length / 2;
        
        for (int i = 0; i < n; i++) {
            cost += costs[i][0] + costs[i + n][1];
        }
        
        return cost;
    }
}