// LeetCode 1472: Design Browser History
// https://leetcode.com/problems/design-browser-history/

// Two Stack Implementation: Use two stacks to keep track of history going forward and backward
class BrowserHistoryStack {
    private String currentPage;
    private Stack<String> backStack;
    private Stack<String> forwardStack;
    
    public BrowserHistory(String homepage) {
        currentPage = homepage;
        backStack = new Stack<>();
        forwardStack = new Stack<>();
    }
    
    public void visit(String url) {
        backStack.push(currentPage);
        currentPage = url;
        forwardStack.clear();
    }
    
    public String back(int steps) {
        while (!backStack.isEmpty() && steps > 0) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
            steps--;
        }
        
        return currentPage;
    }
    
    public String forward(int steps) {
        while (!forwardStack.isEmpty() && steps > 0) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
            steps--;
        }
        
        return currentPage;
    }
}

// Doubly Linked List Implementation: Use a doubly linked list to keep track of history going forward and backward
class BrowserHistory {
    private Node currentPage;

    public BrowserHistory(String homepage) {
        currentPage = new Node(homepage);
    }
    
    public void visit(String url) {
        currentPage.next = new Node(url, currentPage);
        currentPage = currentPage.next;
    }
    
    public String back(int steps) {
        while (steps > 0 && currentPage.prev != null) {
            currentPage = currentPage.prev;
            steps--;
        }
        
        return currentPage.url;
    }
    
    public String forward(int steps) {
        while (steps > 0 && currentPage.next != null) {
            currentPage = currentPage.next;
            steps--;
        }
        
        return currentPage.url;
    }
    
    class Node {
        String url;
        Node prev;
        Node next;
        
        public Node(String url) {
            this.url = url;
        }
        
        public Node(String url, Node prev) {
            this.url = url;
            this.prev = prev;
        }
    }
}
