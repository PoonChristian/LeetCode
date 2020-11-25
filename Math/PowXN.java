// LeetCode 50: Pow(x, n)
// https://leetcode.com/problems/powx-n/
// Recursive and Iterative Solutions

public class PowXN {
    public double myPowRecursive(double x, int n) {
        // Base Case: If n == 0, we know the answer will always be 1
        if (n == 0) {
            return 1.0;
        }
        
        // Call myPow again, except with n cut in half
        double pow = myPow(x, n / 2);
        
        // if n is even, then x^n = x^(n/2) * x^(n/2)
        // if n is odd, then x^n = x^(n/2) * x^(n/2) * x
        // if n is negative, then we just multiply the reciprocal of x, which will be 1 / x
        return n % 2 == 0 ? pow * pow : pow * pow * (n < 0 ? 1 / x : x);
    }

    public double myPowIterative(double x, int n) {
        // Initialize our result variable
        double power = 1;

        // Take the absolute value of n and convert it to a long to prevent int overflow
        long absN = Math.abs((long) n);
        
        // Iterate while absN is still greater than 0
        // Note: We will be iterating at most 32 times since integers contain 32 bits
        while (absN > 0) {
            /* 
              If the least significant bit is a 1, then we need to multiple our result by x^(2^i), where i is the ith bit of the exponent
              Example:
                N = 9 = 2^3 + 2^0 = 1001 in binary. Then:
                x^9 = x^(2^3) * x^(2^0)
              Source: https://leetcode.com/problems/powx-n/discuss/19563/Iterative-Log(N)-solution-with-Clear-Explanation
            */

            if ((absN & 1) == 1) {
                power *= x;
            }
    
            // Shift absN to the right to work with the next bit (this essentially divides n by 2), and multiply x to account for the shift
            absN >>= 1;
            x *= x;
        }
        
        // If n is negative, then we must return the reciprocal (1 / power), otherwise just return the power
        return n < 0 ? 1 / power : power;
    }
}
