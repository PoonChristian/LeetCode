// LeetCode 706: Design HashMap
// https://leetcode.com/problems/design-hashmap/

// HashMap with rehashing implemented
// Collisions are handled with a linked list by storing the key and value at each node
public class MyHashMap {
    class ListNode {
        int key;
        int val;
        ListNode next;
        
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int size;
    private int capacity;
    private double loadFactor = 0.75; 
    private ListNode[] buckets;
    
    public MyHashMap() {
        size = 0;
        capacity = 10;
        buckets = new ListNode[capacity];
    }
    
    public void put(int key, int value) {
        // Resize and rehash all the keys in the HashMap load factor (size / capacity) is greater than 0.75
        if (size / capacity > loadFactor) {
            rehash();
        }
        
        // Get the corresponding index by taking the key MOD capacity
        int index = key % capacity;
        
        // Get the ListNode residing in the bucket at the index
        ListNode head = buckets[index];
        
        // If there are no nodes in the bucket yet, then add a node to the bucket
        if (head == null) {
            ListNode newNode = new ListNode(key, value);
            buckets[index] = newNode;
        } else {
            // Otherwise, traverse the linked list and add the value
            ListNode prev = null;
            ListNode curr = head;
            
            while (curr != null) {
                // If we ever come across the node with the corresponding key in the linked list, then simply update the node's value and return early
                if (curr.key == key) {
                    curr.val = value;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
            
            // If we have not found the key while traversing the linked list, then add the key to the tail of the linked list
            prev.next = new ListNode(key, value);
        }
    }
    
    public int get(int key) {
        // Get the corresponding index by taking the key MOD capacity
        int index = key % capacity;

        // Get the ListNode residing in the bucket at the index
        ListNode head = buckets[index];
        
        // Perform a standard search in the linked list
        while (head != null) {
            // If we ever come across the key, then return its value
            if (head.key == key) {
                return head.val;
            }
            
            // Otherwise, continue traversing the linked list
            head = head.next;
        }
        
        // If we reach the end of the list and haven't found the key, then just return -1
        return -1;
    }
    
    public void remove(int key) {
        // Get the corresponding index by taking the key MOD capacity
        int index = key % capacity;

        // Get the ListNode residing in the bucket at the index
        ListNode head = buckets[index];
        
        // If head is null, then there's nothing to remove, so return early
        if (head == null) {
            return;
        }
        
        // If the head node contains the key, then we want to point buckets[index] to the head's next node
        if (head.key == key) {
            buckets[index] = head.next;
        } else {
            // Otherwise, traverse the linked list and find the key to remove
            while (head.next != null) {
                // If the next node contains the key, then just reroute the next pointer to the next next pointer and return out
                if (head.next.key == key) {
                    head.next = head.next.next;
                    return;
                }
                
                // Otherwise, continue traversing the linked list
                head = head.next;
            }
        }
    }
    
    private void rehash() {
        // Get the new capacity by doubling the original capacity and then adding 1
        int newCapacity = capacity * 2 + 1;

        // Create a new list of buckets with the new capacity
        ListNode[] rehashedBuckets = new ListNode[newCapacity];
        
        // Iterate over the original capacity to get all the buckets that need to be rehashed
        for (int i = 0; i < capacity; i++) {
            // If the bucket at index i is not null, then that means there are nodes to reassign into the new rehashed buckets list
            if (buckets[i] != null) {
                // Get the head ListNode of the bucket
                ListNode head = buckets[i];
                
                // Traverse until we reach the end of the linked list
                while (head != null) {
                    // Get the new index by taking the head's key MOD newCapacity
                    int index = head.key % newCapacity;
                    
                    // If there is no list at the index yet, then create a new ListNode to act as the head and assign it to the index
                    if (rehashedBuckets[index] == null) {
                        rehashedBuckets[index] = new ListNode(head.key, head.val);
                    } else {
                        // Otherwise, get the head ListNode at the new index
                        ListNode newHead = rehashedBuckets[index];

                        // Create the new ListNode to add to the end of the list
                        ListNode newNext = new ListNode(head.key, head.val);
                        
                        // Traverse to the end of the linked list
                        while (newHead.next != null) {
                            newHead = newHead.next;
                        }
                        
                        // Set the tail of the linked list to be the newNext node
                        newHead.next = newNext;
                    }

                    // Move head to its next pointer to process the next node for rehashing
                    head = head.next;
                }
            }
        }

        // Set the new capacity and new buckets
        capacity = newCapacity;
        buckets = rehashedBuckets;
    }
}
