// LeetCode 496: Next Greater Element I
// https://leetcode.com/problems/next-greater-element-i/

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Initialize a hashmap with the following key/value pair
        // {element: next greater element}
        Map<Integer, Integer> greaterElementMap = new HashMap<Integer, Integer>();

        // Initialize a stack to keep track of numbers that still need to be assigned a
        // next greater element
        Stack<Integer> stack = new Stack<Integer>();

        // Initialize an output array
        int[] output = new int[nums1.length];

        // Loop over the second array
        for (int num : nums2) {

            // While the stack is NOT empty and the value at the top is less than the
            // current value, continually pop the values off the stack and update the
            // hashmap with: { stack.pop(), currentValue }
            while (!stack.isEmpty() && stack.peek() < num) {
                greaterElementMap.put(stack.pop(), num);
            }

            // Push the current value onto the stack to check for its next greater element
            stack.push(num);
        }

        // Loop over the first array
        for (int i = 0; i < nums1.length; i++) {

            // Set the value of the output array at index i equal to
            // the hashmap value of nums1[1] or -1 if there is no greater element
            output[i] = greaterElementMap.getOrDefault(nums1[i], -1);
        }

        // Return the output array
        return output;
    }
}
