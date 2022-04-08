package cn.com.myproject.learn.leetcode;

public class TrieNode1 {
    TrieNode1[] children;
    int count;
    TrieNode1() {
        children = new TrieNode1[26];
        count = 0;
    }
    public TrieNode1 get(char c) {
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new TrieNode1();
            count++;
        }
        return children[c - 'a'];
    }
}
