// LeetCode 707: Design Linked List
// https://leetcode.com/problems/design-linked-list/

// Data Structure: Doubly linked list with head and tail
public class MyLinkedList {
    class ListNode {
        int val;
        ListNode prev;
        ListNode next;
        
        public ListNode(int val) {
            this.val = val;
        }
        
        public ListNode(int val, ListNode prev, ListNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    
    int size;
    ListNode head;
    ListNode tail;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        
        return traverseFromHead(index).val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        
        ListNode nodeAtIndex = index <= size / 2 ? traverseFromHead(index) : traverseFromTail(size - index - 1);
        ListNode newNode = new ListNode(val);
        
        newNode.next = nodeAtIndex;
        newNode.prev = nodeAtIndex.prev;
        nodeAtIndex.prev.next = newNode;
        nodeAtIndex.prev = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        
        ListNode nodeAtIndex = index <= size / 2 ? traverseFromHead(index) : traverseFromTail(size - index - 1);
        
        nodeAtIndex.prev.next = nodeAtIndex.next;
        nodeAtIndex.next.prev = nodeAtIndex.prev;
        
        size--;
    }
    
    private ListNode traverseFromHead(int index) {
        ListNode curr = head;
        
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        
        return curr;
    }
    
    private ListNode traverseFromTail(int index) {
        ListNode curr = tail;
        
        for (int i = 0; i <= index; i++) {
            curr = curr.prev;
        }
        
        return curr;
    }
}
