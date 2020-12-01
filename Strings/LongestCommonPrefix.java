// LeetCode 14: Longest Common Prefix
// https://leetcode.com/problems/longest-common-prefix/
// Horizontal Scan, Vertical Scan, and Trie Solutions

public class LongestCommonPrefix {
    public String horizontalScan(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder prefix = new StringBuilder(strs[0]);

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix.toString()) != 0) {
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }

        return prefix.toString();
    }

    public String verticalScan(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return prefix.toString();
                }
            }

            prefix.append(c);
        }

        return prefix.toString();
    }

    public String trieScan(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        Trie trie = new Trie();
        for (String str : strs) {
            trie.insert(str);
        }
        return trie.searchLongestPrefix();
    }

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return node.isEnd;
        }

        public String searchLongestPrefix() {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();
            while (!node.isEnd) {
                int numChildren = 0;
                int index = 0;
                for (int i = 0; i < 26; i++) {
                    if (node.children[i] != null) {
                        numChildren++;
                        index = i;
                    }
                }
                if (numChildren != 1) {
                    return prefix.toString();
                }
                prefix.append((char) ('a' + index));
                node = node.children[index];
            }
            return prefix.toString();
        }
    }
}