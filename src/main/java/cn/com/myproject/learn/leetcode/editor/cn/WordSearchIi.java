//Given a 2D board and a list of words from the dictionary, find all words in th
//e board. 
//
// Each word must be constructed from letters of sequentially adjacent cell, whe
//re "adjacent" cells are those horizontally or vertically neighboring. The same l
//etter cell may not be used more than once in a word. 
//
// 
//
// Example: 
//
// 
//Input: 
//board = [
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//words = ["oath","pea","eat","rain"]
//
//Output: ["eat","oath"]
// 
//
// 
//
// Note: 
//
// 
// All inputs are consist of lowercase letters a-z. 
// The values of words are distinct. 
// 
// Related Topics 字典树 回溯算法

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class WordSearchIi{
    public static void main(String[] args) {
       Solution solution = new WordSearchIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] delta = new int[]{0, 1, 0, -1, 0};
        char[][] board;
        boolean[][] visited;
        List<String> res;


        public List<String> findWords(char[][] board, String[] words) {
            res = new LinkedList<>();
            if (words == null || words.length == 0) {
                return res;
            }

            // 构建字典树
            Trie root = new Trie();
            for (String word : words) {
                root.insert(word);
            }

            int m = board.length, n = board[0].length;
            this.board = board;
            this.visited = new boolean[m][n];

            // 回溯匹配
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 回溯
                    findWords(root, i, j, new StringBuffer());
                }
            }
            return res;
        }
        // 返回剪枝标识
        private boolean findWords(Trie root, int i, int j, StringBuffer word) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
                return false;
            }
            char cur = board[i][j];
            // 不匹配
            if (visited[i][j] || root.children[cur - 'a'] == null) {
                return false;
            }

            // 标记试探
            visited[i][j] = true;
            word.append(cur);
            // 如果是单词结尾，加入答案
            if (root.children[cur - 'a'].isEnding) {
                res.add(word.toString());
                // 如果该字符是字典树叶子结点，已匹配完，可删除
                if (root.children[cur - 'a'].size == 0) {
                    root.children[cur - 'a'] = null;
                    // 回溯
                    word.setLength(word.length() - 1);
                    visited[i][j] = false;
                    return --root.size == 0;
                }
            }

            for (int k = 0; k < 4; k++) {
                // 矩形试探
                int x = i + delta[k], y = j + delta[k + 1];
                // cur的字节点已匹配成功且删除，判断cur是否需要删除
                if (findWords(root.children[cur - 'a'], x, y, word)) {
                    // 只有cur一个字节点，删除cur
                    if (root.children[cur - 'a'].size == 0) {
                        root.children[cur - 'a'] = null;
                        // 回溯
                        word.setLength(word.length() - 1);
                        visited[i][j] = false;
                        return --root.size == 0;
                    }
                }
            }
            // 回溯
            word.setLength(word.length() - 1);
            visited[i][j] = false;

            if (root.children[cur - 'a'].isEnding) root.children[cur - 'a'].isEnding = false;
            return false;
        }

        class Trie {
            // 字节点个数（用于减枝判断）
            int size;
            boolean isEnding;
            Trie[] children = new Trie[26];

            public void insert(String word) {
                if (word == null || word.isEmpty()) return;

                Trie temp = this;
                for (char c : word.toCharArray()) {
                    if (temp.children[c - 'a'] == null) {
                        temp.children[c - 'a'] = new Trie();
                        temp.size++;
                    }
                    temp = temp.children[c - 'a'];
                }
                temp.isEnding = true;
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}