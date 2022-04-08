//Implement a trie with insert, search, and startsWith methods. 
//
// Example: 
//
// 
//Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // returns true
//trie.search("app");     // returns false
//trie.startsWith("app"); // returns true
//trie.insert("app");   
//trie.search("app");     // returns true
// 
//
// Note: 
//
// 
// You may assume that all inputs are consist of lowercase letters a-z. 
// All inputs are guaranteed to be non-empty strings. 
// 
// Related Topics 设计 字典树

  
package cn.com.myproject.learn.leetcode.editor.cn;

import cn.com.myproject.learn.leetcode.TrieNode;
import cn.com.myproject.learn.leetcode.TrieNode1;

import java.util.Map;

public class ImplementTriePrefixTree{
    public static void main(String[] args) {
        Trie solution = new ImplementTriePrefixTree().new Trie();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        private boolean isEnd;
        private Trie[] next;
        /** Initialize your data structure here. */
        public Trie() {
            isEnd = false;
            next = new Trie[26];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            Trie curr = this;
            char[] words = word.toCharArray();
            for (int i = 0; i < words.length; i++) {
                int n = words[i] - 'a';
                if (curr.next[n] == null) {
                    curr.next[n] = new Trie();
                }
                curr = curr.next[n];
            }
            curr.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie node = searchPrefix(prefix);
            return node != null;
        }
        private Trie searchPrefix(String word) {
            Trie node = this;
            char[] words = word.toCharArray();
            for (int i = 0;i < words.length;i++) {
                node = node.next[words[i] - 'a'];
                if (node == null) return null;
            }
            return node;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}