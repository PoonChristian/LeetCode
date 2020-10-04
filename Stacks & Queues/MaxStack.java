// LeetCode 716: Max Stack
// https://leetcode.com/problems/max-stack/

public class MaxStack {

    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<Integer>();
        maxStack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        maxStack.push(maxStack.isEmpty() ? x : Math.max(x, maxStack.peek()));
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> tempStack = new Stack<Integer>();

        while (top() != max) {
            tempStack.push(pop());
        }

        pop();

        while (!tempStack.isEmpty()) {
            push(tempStack.pop());
        }

        return max;
    }

}
