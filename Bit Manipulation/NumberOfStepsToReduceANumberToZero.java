// LeetCode 1342: Number of Steps to Reduce a Number to Zero
// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

public class NumberOfStepsToReduceANumberToZero {
    public int numberOfStepsIntuitive(int num) {
        int steps = 0;

        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }

            steps++;
        }
        return steps;
    }

    public int numberOfStepsBits(int num) {
        if (num == 0) {
            return 0;
        }
        
        int steps = 0;
        String binaryString = Integer.toBinaryString(num);
        
        for (int i = 0; i < binaryString.length(); i++) {
            /* 
              Operations in Detail:
                1. Subtracting 1 reduces the least significant bit to 0
                2. Dividing by 2 chops off the least significant bit
              Logic:
                1. If we encounter a 1, we must subtract first and then divide by 2 (two steps)
                2. If we encounter a 0, we can just divide by 2 (one step)
            */
            if (binaryString.charAt(i) == '1') {
                steps += 2;
            } else {
                steps++;
            }
        }
        
        // The only case where the above logic does not apply is at the very end with the most significant bit, which will always be 1
        // When we subtract 1 from the most significant bit, we immediately get 0, so we must subtract 1 from the steps to compensate
        return steps - 1;
    }
}