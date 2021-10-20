// LeetCode 225: Implement Stack using Queues
// https://leetcode.com/problems/implement-stack-using-queues/

public class QueueStack {

    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

}

class MyStackWithTwoQueues {
    
    Queue<Integer> pushQueue;
    Queue<Integer> popQueue;
    Integer top;

    /** Initialize your data structure here. */
    public MyStack() {
        pushQueue = new LinkedList<Integer>();
        popQueue = new LinkedList<Integer>();
        top = null;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        pushQueue.add(x);
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int topElement = top;
        // Move the elements from the first queue to the second queue
        while (pushQueue.size() > 1) {
            top = pushQueue.remove();
            popQueue.add(top);
        }
        pushQueue.remove();
        // Swap back the queues to redo the process over again
        Queue<Integer> temp = pushQueue;
        pushQueue = popQueue;
        popQueue = temp;
        return topElement;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return pushQueue.isEmpty() && popQueue.isEmpty();
    }
}