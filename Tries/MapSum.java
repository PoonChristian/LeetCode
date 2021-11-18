// LeetCode 677: Map Sum Pairs
// https://leetcode.com/problems/map-sum-pairs/

// Data Structure: Trie that keeps track of the value of the each node and makes changes by taking the difference of the original value with then new value
public class MapSum {
    // Use a HashMap for easy access to the values of the keys
    Map<String, Integer> map;

    // Use a Trie for easy access to prefixes of the keys
    TrieNode root;
    
    public MapSum() {
        map = new HashMap<>();
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        // The delta is the difference between the original key's value and the new value
        int delta = val - map.getOrDefault(key, 0);
        
        // Update the map with the new key-value pair
        map.put(key, val);
        
        // Traverse the trie and add the new key or update an existing key's values with the delta
        TrieNode curr = root;

        // Update the root value's key
        curr.value += delta;
        
        // Traverse up until we reach the end of the key
        for (char c : key.toCharArray()) {
            // Create a new TrieNode if a mapping is null
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            
            // Go to the next character and update its value
            curr = curr.children[c - 'a'];
            curr.value += delta;
        }
    }
    
    public int sum(String prefix) {
        TrieNode curr = root;
        
        for (char c : prefix.toCharArray()) {
            // If there is no TrieNode for char c, that means the prefix doesn't exist in the trie, so return 0
            if (curr.children[c - 'a'] == null) {
                return 0;
            }
            
            curr = curr.children[c - 'a'];
        }
        
        // Otherwise, if we reach the end of the prefix, return the value associated with that prefix
        return curr.value;
    }
    
    class TrieNode {
        TrieNode[] children;
        int value;
        
        public TrieNode() {
            children = new TrieNode[26];
            value = 0;
        }
    }
}
