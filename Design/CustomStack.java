// LeetCode 1381: Design a Stack With Increment Operation
// https://leetcode.com/problems/design-a-stack-with-increment-operation/

// Implementation: Use an array for easy access to elements at the top and bottom of the stack
public class CustomStack {
    private Integer[] stack;
    private int size;

    public CustomStack(int maxSize) {
        this.stack = new Integer[maxSize];
        this.size = 0;
    }
    
    public void push(int x) {
        if (size < stack.length) {
            stack[size++] = x;
        }
    }
    
    public int pop() {
        if (size <= 0) {
            return -1;
        }
        
        return stack[--size];
    }
    
    public void increment(int k, int val) {
        if (k > size) {
            k = size;
        }
        
        for (int i = 0; i < k; i++) {
            stack[i] += val;
        }
    }
}
