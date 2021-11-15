// LeetCode 211: Design Add and Search Words Data Structure
// https://leetcode.com/problems/design-add-and-search-words-data-structure/

/*  Data Structure: Trie
    Concept: Store all added words in a trie
    Time Complexity:
        add - O(w * n) where w is the number of words in the trie and n is the max number of characters in each word
        search - O(w * n) where w is the number of words in the trie and n is the max number of characters in each word

    Space Complexity: O(w * n) where w is the number of words in the trie and n is the max number of characters in each word
*/
public class WordDictionary {
    // TrieNode that stores lowercase letters only
    class TrieNode {
        TrieNode[] children;
        boolean endOfWord;
        
        public TrieNode() {
            children = new TrieNode[26];
            endOfWord = false;
        }
    }
    
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    // Standard add function for a Trie
    public void addWord(String word) {
        TrieNode curr = root;
        
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            
            curr = curr.children[c - 'a'];
        }
        
        curr.endOfWord = true;
    }
    
    // Search function will call a recursive helper function since it must handle wildcards
    public boolean search(String word) {
        return searchWord(root, word, 0);
    }
    
    private boolean searchWord(TrieNode curr, String word, int index) {
        // Base Case: If the index is equal to the word's length, that means we found a path to the end of the word, so return whether or not the TrieNode curr is the end of a word
        if (index == word.length()) {
            return curr.endOfWord;
        }
        
        // Extract the letter from the word at the index
        char letter = word.charAt(index);
        
        // First, check if the letter is a wildcard '.'
        if (letter == '.') {
            // If this hits, then we must iterate through all the children and try to find a path from every non-null child
            for (int i = 0; i < curr.children.length; i++) {
                // If the TrieNode child at i is not null and the recursive call from that child finds a path to the end of the word, then return true
                if (curr.children[i] != null && searchWord(curr.children[i], word, index + 1)) {
                    return true;
                }
            }
            
            // Otherwise if there is no path from any of the children above, then return false
            return false;
        } else if (curr.children[letter - 'a'] == null) {
            // If a TrieNode for the letter doesn't exist, then we know there is absolutely no path. Return false
            return false;
        } else {
            // Otherwise, move curr to its child with the letter
            curr = curr.children[letter - 'a'];
        }
        
        // Return the recursive call with the new TrieNode and index incremented by 1 to continue searching
        return searchWord(curr, word, index + 1);
    }
}
