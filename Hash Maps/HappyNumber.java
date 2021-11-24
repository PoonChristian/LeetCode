// LeetCode 202: Happy Number
// https://leetcode.com/problems/happy-number/

public class HappyNumber {
    public boolean isHappy(int n) {
        // Keep track of the numbers we've calculated from the squares of the digits
        Set<Integer> visited = new HashSet<>();
        
        // Iterate while n is not equal to 1
        while (n != 1) {
            // Simulate taking the sums of the squares of each digit
            int current = n;
            int squareSum = 0;
            
            while (current != 0) {
                squareSum += (current % 10) * (current % 10);
                current /= 10;
            }
            
            // If our HashSet ever contains the square sum, then we know we're in a cycle since we've encountered the number already, so return false
            if (visited.contains(squareSum)) {
                return false;
            }
            
            // Otherwise, record the square sum in our HashSet and set n equal to the squareSum
            visited.add(squareSum);
            n = squareSum;
        }
        
        // If the above loop breaks, then we know n must equal to 1, so return true
        return true;
    }
}