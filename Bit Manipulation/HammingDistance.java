// LeetCode 461: Hamming Distance
// https://leetcode.com/problems/hamming-distance/

public class HammingDistance {
    public int hammingDistanceRightShift(int x, int y) {
        // XOR both numbers first
        int xor = x ^ y;
        // Initialize a distance variable
        int distance = 0;
        
        // Iterate until the xor result is 0
        while (xor != 0) {
            /*
              Check if the result is odd because that means the least significant bit is 1
              Since the bit is 1, then that means the corresponding bit between x and y were different due to XOR (0 ^ 1 = 1)
              After checking the least significant bit, right shift to check the next bit, and keep doing this until our xor value is 0
              NOTE: Arithmetic right shift (>>) would fail if ONE of the input is negative, so we should use logical right shift (>>>) instead

              Example: x = 1, y = 4
                1   (0 0 0 1)
              ^ 4   (0 1 0 0)
                    (0 1 0 1)
                
                1. 0 1 0 1 -> least significant bit is 1, so increment distance by 1 (= 1)
                2.   0 1 0 -> least significant bit is 0, so do nothing
                3.     0 1 -> least significant bit is 1, so increment distance by 1 (= 2)
                4.       0 -> least significant bit is 0, so do nothing
                Distance = 2
            */
            if (xor % 2 == 1) {
                distance++;
            }
            xor = xor >>> 1;
        }
        
        // Return the resulting distance
        return distance;
    }

    public int hammingDistanceBrianKernighan(int x, int y) {
        // XOR both numbers first
        int xor = x ^ y;
        // Initialize a distance variable
        int distance = 0;

        // Iterate until the xor result is 0
        while (xor != 0) {
            // At each iteration, we'll increment the distance
            distance++;

            /*
              xor = xor & (xor - 1) essentially removes the rightmost bit that is equal to 1

              Example w/ distance 2:
                1.         x = 1 0 0 0 1 0 0 0
                       x - 1 = 1 0 0 0 0 1 1 1
                 x & (x - 1) = 1 0 0 0 0 0 0 0
                                       ↑
                2.         x = 1 0 0 0 0 0 0 0
                       x - 1 = 0 1 1 1 1 1 1 1
                 x & (x - 1) = 0 0 0 0 0 0 0 0
                               ↑
            */
            xor = xor & (xor - 1);
        }

        // Return the resulting distance
        return distance;
    }
}
