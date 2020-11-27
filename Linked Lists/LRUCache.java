// LeetCode 146: LRU Cache
// https://leetcode.com/problems/lru-cache/

public class LRUCache {
    class DListNode {
        int key;
        int val;
        DListNode prev;
        DListNode next;
        
        public DListNode() {
            
        }
        
        public DListNode(int key, int val, DListNode prev, DListNode next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    
    private void moveNodeToHead(DListNode node) {
        DListNode prev = node.prev;
        DListNode next = node.next;
        
        // 1. Update node's prev and next pointers
        prev.next = next;
        next.prev = prev;
        
        // 2. Move node to head and update its prev and next
        node.prev = head;
        node.next = head.next;
        
        // 3. Head's next's prev to be the node, and head's next to be the node
        updateHead(node);
    }
    
    private void updateHead(DListNode node) {
        head.next.prev = node;
        head.next = node;
    }
    
    private void updateTail() {
        DListNode evictNode = tail.prev;
        evictNode.prev.next = tail;
        tail.prev = evictNode.prev;
        cacheMap.remove(evictNode.key);
    }
    
    private int size;
    private int capacity;
    private DListNode head;
    private DListNode tail;
    private Map<Integer, DListNode> cacheMap;
    
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.prev = head;
        cacheMap = new HashMap<Integer, DListNode>();
    }
    
    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        
        DListNode node = cacheMap.get(key);
        moveNodeToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            DListNode node = cacheMap.get(key);
            node.key = key;
            node.val = value;
            moveNodeToHead(node);
        } else {
            DListNode newNode = new DListNode(key, value, head, head.next);
            cacheMap.put(key, newNode);
            updateHead(newNode);
            size++;
            
            if (size > capacity) {
                updateTail();
                size--;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*

head <--> tail

head <--> (2,2) <--> (1,1) <--> tail

1. Update current node's prev and next
node = (2,2) <--> tail
          ^  (1,1) ^
          
2. Move current node to head and update prevs and nexts
head <-- (1,1) --> (2,2) <--> tail
*/
