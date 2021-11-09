// LeetCode 605: Can Place Flowers
// https://leetcode.com/problems/can-place-flowers/

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // If n is 0, then we have no flowers to place, so we should immediately return true
        if (n == 0) {
            return true;
        }

        // Iterate through the flowerbed or until we've placed n flowers
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            // Set prev, curr, and next
            // Use ternary operators for prev and next to handle the edge of the flowerbed (0 or flowerbed.length - 1)
            // We can assume that outside of the edges are 0s
            int prev = i == 0 ? 0 : flowerbed[i - 1];
            int curr = flowerbed[i];
            int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
            
            // We simply need to check whether or not our current spot is not adjacent to a flower.
            // If there are no flowers next to our current spot, then place it and decrement n
            if (prev == 0 && curr == 0 && next == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        
        // Return whether or not we've placed all our flowers in the flowerbed by checking the count of n
        return n <= 0;
    }
}
