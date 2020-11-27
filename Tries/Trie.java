// LeetCode 208: Implement Trie (Prefix Tree)
// https://leetcode.com/problems/implement-trie-prefix-tree/

public class Trie {
    class TrieNode {
        TrieNode[] children;
        boolean endOfWord;
        
        public TrieNode() {
            children = new TrieNode[26];
            endOfWord = false;
        }
    }
    
    private TrieNode getNode(String word) {
        TrieNode curr = root;
        
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return null;
            }
            
            curr = curr.children[c - 'a'];
        }
        
        return curr;
    }
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            
            curr = curr.children[c - 'a'];
        }
        
        curr.endOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = getNode(word);
        return node != null && node.endOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
