// LeetCode 676: Implement Magic Dictionary
// https://leetcode.com/problems/implement-magic-dictionary/

// Data Structure: Trie, where the search function modifies each character of the searchWord to find a word that is already in the trie
public class MagicDictionary {
    TrieNode root;
    
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            addWord(s);
        }
    }
    
    public boolean search(String searchWord) {
        char[] wordArray = searchWord.toCharArray();
        
        for (int i = 0; i < wordArray.length; i++) {
            char temp = wordArray[i];
            
            for (int j = 0; j < 26; j++) {
                // If we reach the original character in this loop, just disregard it
                if (j == temp - 'a') {
                    continue;
                }
                
                // Set the new character at index i
                wordArray[i] = (char) (j + 'a');
                
                // Look for the new word in the trie
                if (foundWord(wordArray)) {
                    return true;
                }
            }
            
            wordArray[i] = temp;
        }
        
        return false;
    }
    
    private void addWord(String s) {
        TrieNode curr = root;
        
        for (char c : s.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            
            curr = curr.children[c - 'a'];
        }
        
        curr.endOfWord = true;
    }
    
    private boolean foundWord(char[] word) {
        TrieNode curr = root;
        
        for (char c : word) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            
            curr = curr.children[c - 'a'];
        }
        
        return curr.endOfWord;
    }
    
    class TrieNode {
        TrieNode[] children;
        boolean endOfWord;
        
        public TrieNode() {
            children = new TrieNode[26];
            endOfWord = false;
        }
    }
}
