// LeetCode 69: Sqrt(x)
// https://leetcode.com/problems/sqrtx/

public class SqrtX {
    public int mySqrt(int x) {
        // If x is less than or equal to 1, we can just return x
        if (x <= 1) {
            return x;
        }
        
        // Perform a binary search from 1 to x / 2 since we know for sure the square root must be within this range
        int left = 1;
        int right = x / 2;
        int squareRoot = 0;
        
        while (left <= right) {
            int mid = (left + right + 1) / 2;
            
            // Whenever mid^2 is less than or equal to x, then we can set our new square root and move left to mid + 1
            // We must cast mid^2 to a long to prevent integer overflow
            if ((long) mid * mid <= x) {
                squareRoot = mid;
                left = mid + 1;
            } else {
                // Otherwise if mid is greater than x, than we know the square root is on the left side of mid, so set right to mid - 1
                right = mid - 1;
            }
        }
        
        // Return the square root after the binary search is done 
        return squareRoot;
    }
}
