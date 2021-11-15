// LeetCode 453: Minimum Moves to Equal Array Elements
// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

/*
    Algorithm: Instead of incrementing n - 1 elements by 1 every time to make the elements equal, we can decrement them instead
        Once we decrement all elements to equal the min element in the array, the sum of those elements will be (nums.length * min)
        The number of moves to modify the original array to be the final array would be the difference between those sums
        i.e. sumOfOriginalArray - sumOfEqualElementsArray --> sum - (nums.length * min)
    Source: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/discuss/1567828/Java-oror-Explained-with-Example-oror-Math-Problem
*/
public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }
        
        return sum - (nums.length * min);
    }
}
