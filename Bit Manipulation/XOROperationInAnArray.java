// LeetCode 1486: XOR Operation in an Array
// https://leetcode.com/problems/xor-operation-in-an-array/

public class XOROperationInAnArray {
    public int xorOperation(int n, int start) {
        // Initialize the xor result to 0
        int xor = 0;
        
        // Iterate up to n
        for (int i = 0; i < n; i++) {
            // At each iteration, set xor = xor ^ (start + 2*i)
            xor ^= (start + 2*i);
        }
        
        // Return the final xor result
        return xor;
    }
}
