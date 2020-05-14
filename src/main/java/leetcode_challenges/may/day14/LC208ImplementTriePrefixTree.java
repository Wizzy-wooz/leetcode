package leetcode_challenges.may.day14;

public class LC208ImplementTriePrefixTree {
    //  Implement a trie with insert, search, and startsWith methods.
//
//    Example:
//
//    Trie trie = new Trie();
//
//  trie.insert("apple");
//  trie.search("apple");   // returns true
//  trie.search("app");     // returns false
//  trie.startsWith("app"); // returns true
//  trie.insert("app");
//  trie.search("app");     // returns true
    /** Initialize your data structure here. */
    TrieNode root;

    /** Initialize your data structure here. */
    public LC208ImplementTriePrefixTree() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.children[j] == null) {
                node.children[j] = new TrieNode();
            }
            node = node.children[j];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.children[j] == null) return false;
            node = node.children[j];
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int j = prefix.charAt(i) - 'a';
            if (node.children[j] == null) return false;
            node = node.children[j];
        }
        return true;
    }
}
