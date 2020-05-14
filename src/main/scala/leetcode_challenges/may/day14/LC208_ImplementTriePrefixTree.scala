package leetcode_challenges.may.day14

import scala.annotation.tailrec

class LC208_ImplementTriePrefixTree {
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
val child = new Array[LC208_ImplementTriePrefixTree](26)
  var isWord = false

  def insert(word: String) {
    @tailrec
    def insertStringToTrie(st: String, currTrie: LC208_ImplementTriePrefixTree): Unit = {
      if(st.length == 0) {
        currTrie.isWord = true
      } else {
        if(currTrie.child(st.charAt(0) - 'a') == null) {
          currTrie.child(st.charAt(0) - 'a') = new LC208_ImplementTriePrefixTree()
        }
        insertStringToTrie(st.substring(1), currTrie.child(st.charAt(0) - 'a'))
      }
    }

    insertStringToTrie(word, this)
  }

  /** Returns if the word is in the trie. */
  def search(word: String): Boolean = {
    @tailrec
    def searchRec(st: String, currTrie: LC208_ImplementTriePrefixTree): Boolean = {
      if(st.length == 0) currTrie != null && currTrie.isWord
      else {
        if(currTrie == null || currTrie.child(st.charAt(0) - 'a') == null) false
        else searchRec(st.substring(1), currTrie.child(st.charAt(0) - 'a'))
      }
    }
    searchRec(word, this)
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  def startsWith(prefix: String): Boolean = {
    @tailrec
    def searchRec(st: String, currTrie: LC208_ImplementTriePrefixTree): Boolean = {
      if(st.length == 0) true
      else {
        if(currTrie == null || currTrie.child(st.charAt(0) - 'a') == null) false
        else searchRec(st.substring(1), currTrie.child(st.charAt(0) - 'a'))
      }
    }
    searchRec(prefix, this)
  }
}