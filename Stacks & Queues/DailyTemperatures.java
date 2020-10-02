// LeetCode 739: Daily Temperatures
// https://leetcode.com/problems/daily-temperatures/

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        // Initialize output array with same length as T
        int[] output = new int[T.length];

        // Initialize a stack to keep track of indices
        Stack<Integer> stack = new Stack<Integer>();

        // Loop through T array backwards
        for (int i = T.length - 1; i >= 0; i--) {
            // Iterate while the stack isn't empty
            // Continually pop the stack if T[stack.peek()] is less than or equal to T[i]
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }

            // If the stack is empty, then there are no days hotter than this one
            // i.e. set output[i] = 0
            // Otherwise, the next hottest day is at the top of the stack
            // i.e. set output[i] = stack.peek() - i
            output[i] = stack.isEmpty() ? 0 : stack.peek() - i;

            // Push the current index onto the stack
            stack.push(i);
        }

        // Return the output array
        return output;
    }
}
