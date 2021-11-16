// LeetCode 1133: Largest Unique Number
// https://leetcode.com/problems/largest-unique-number/

public class LargestUniqueNumber {
    public int largestUniqueNumber(int[] A) {
        int[] counts = new int[1001];

        for (int num : A) {
            counts[num]++;
        }

        for (int i = 1000; i >= 0; i--) {
            if (counts[i] == 1) {
                return i;
            }
        }

        return -1;
    }
}
