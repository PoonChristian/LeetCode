// LeetCode 504: Base 7
// https://leetcode.com/problems/base-7/

/*
    Algorithm: To get base x of any decimal (base 10) number, do the following steps:
        1. Get the remainder of the number with (number MOD x)
        2. Add it to the result
        3. Divide the number by x
        4. Repeat steps 1-3 until the number is 0
        5. The number will be the result IN REVERSE because:
            a. The first iteration will calculate the least significant digit
            b. The last iteration will calculate the most significant digit

*/
public class Base7 {
    public String convertToBase7(int num) {
        // Edge Case: Num is 0
        if (num == 0) {
            return "0";
        }
        
        StringBuilder base7 = new StringBuilder();
        
        // We want to get the positive number to avoid unexpected behavior with negative numbers
        int posNum = Math.abs(num);
        
        while (posNum > 0) {
            base7.append(posNum % 7);
            posNum /= 7;
        }
        
        // If the original num is negative, then just add the negative sign to the end
        if (num < 0) {
            base7.append("-");
        }
        
        return base7.reverse().toString();
    }
}
