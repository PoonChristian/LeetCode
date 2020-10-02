// LeetCode 503: Next Greater Element II
// https://leetcode.com/problems/next-greater-element-ii/

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        // Initialize length and output array
        int length = nums.length;
        int[] output = new int[length];

        // Fill the output array with -1's to easily handle max elements
        Arrays.fill(output, -1);

        // Initialize a stack to keep track of indices
        Stack<Integer> stack = new Stack<Integer>();

        // Loop over double the length of the array (allows for circular iteration)
        for (int i = 0; i < length * 2; i++) {

            // Initialize an index using the modulus operator over the original length
            int currentIndex = i % length;

            // While the stack is NOT empty and the value at the top index is less than the
            // value at current index, continually pop the indices off the stack and update
            // the values at those indices with the value at the current index
            while (!stack.isEmpty() && nums[stack.peek()] < nums[currentIndex]) {
                output[stack.pop()] = nums[currentIndex];
            }

            // If the index < length, push the index onto the stack
            // These indices will be used to update the output array
            if (i < length) {
                stack.push(i);
            }
        }

        // Return the output array
        return output;
    }
}
