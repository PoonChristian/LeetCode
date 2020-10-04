// LeetCode 155: Min Stack
// https://leetcode.com/problems/min-stack/

public class MinStack {

    private class Pair {
        int val;
        int min;

        public Pair(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private Stack<Pair> stack = new Stack<Pair>();

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Pair>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new Pair(x, x));
            return;
        }

        int prevMin = stack.peek().min;
        stack.push(new Pair(x, Math.min(x, prevMin)));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

}
