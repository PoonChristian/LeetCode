// LeetCode 232: Implement Queue using Stacks
// https://leetcode.com/problems/implement-queue-using-stacks/

public class StackQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new Stack<Integer>();
        popStack = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        populatePopStack();
        return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        populatePopStack();
        return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    private void populatePopStack() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

}
