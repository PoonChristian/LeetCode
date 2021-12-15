// LeetCode 622: Design Circular Queue
// https://leetcode.com/problems/design-circular-queue/

// Implementation: LinkedList with a head (front) and tail (rear) pointer
public class MyCircularQueue {

    private ListNode front;
    private ListNode rear;
    private int size;
    private int capacity;
    
    public MyCircularQueue(int k) {
        front = null;
        rear = null;
        size = 0;
        capacity = k;
    }
    
    public boolean enQueue(int value) {
        // If the circular queue is full, then we can't enqueue anything, so return false
        if (isFull()) {
            return false;
        }
        
        // If the circular queue is empty, then we set the front and rear equal to the enqueued node
        if (isEmpty()) {
            ListNode node = new ListNode(value);
            front = node;
            rear = node;
        } else {
            // If the circular queue is not empty, then we need to create a new node that points to the front (to maintain the circular nature)
            // The rear will be the newly created node, so set its next value equal to the node, then advance it forward
            rear.next = new ListNode(value, front);
            rear = rear.next;
        }
        
        // Increase the size of the circular queue by 1 and then return true
        size++;
        return true;
    }
    
    public boolean deQueue() {
        // If the circular queue is empty, then we can't dequeue anything, so return false
        if (isEmpty()) {
            return false;
        }
        
        // If the circular queue only has one element, then simply assign front and rear to null
        if (size == 1) {
            front = null;
            rear = null;
        } else {
            // If the circular queue has more than one element, then set front equal to front.next
            // We also have to update rear.next to point to our new front (to maintain the circular nature)
            front = front.next;
            rear.next = front;
        }
        
        // Decrease the size of the circular queue by 1 and then return true
        size--;
        return true;
    }
    
    public int Front() {
        // Return -1 if empty and front.val if not empty
        return isEmpty() ? -1 : front.val;
    }
    
    public int Rear() {
        // Return -1 if empty and rear.val if not empty
        return isEmpty() ? -1 : rear.val;
    }
    
    public boolean isEmpty() {
        // The circular queue is empty if both front and rear are null
        return front == null && rear == null;
    }
    
    public boolean isFull() {
        // The circular queue is full if the size reaches the capacity
        return size == capacity;
    }
    
    // Custom ListNode class 
    class ListNode {
        int val;
        ListNode next;
        
        public ListNode(int val) {
            this.val = val;
        }
        
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
