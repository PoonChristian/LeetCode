// LeetCode 901: Online Stock Span
// https://leetcode.com/problems/online-stock-span/

// Implementation: Similar to "Daily Temperatures" stack problem
public class StockSpanner {
    // Keep a stack with pair values [price, span]
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        // Span will always start at 1 to include the current price
        int span = 1;
        
        // Iterate while the stack is empty and the last price is less than or equal to our current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            // If the condition hits, then add the last span to our current span
            // We pop the last pair since we'll be recording all the stock prices less than the last price anyway by incrementing it to our current span
            span += stack.pop()[1];
        }
        
        // Push the pair into the stack so we can process the next price against this one
        stack.push(new int[]{price, span});
        
        // Return the span
        return span;
    }
}
