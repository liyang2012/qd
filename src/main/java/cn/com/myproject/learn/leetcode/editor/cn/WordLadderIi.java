//Given two words (beginWord and endWord), and a dictionary's word list, find al
//l shortest transformation sequence(s) from beginWord to endWord, such that: 
//
// 
// Only one letter can be changed at a time 
// Each transformed word must exist in the word list. Note that beginWord is not
// a transformed word. 
// 
//
// Note: 
//
// 
// Return an empty list if there is no such transformation sequence. 
// All words have the same length. 
// All words contain only lowercase alphabetic characters. 
// You may assume no duplicates in the word list. 
// You may assume beginWord and endWord are non-empty and are not the same. 
// 
//
// Example 1: 
//
// 
//Input:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//Output:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
// 
//
// Example 2: 
//
// 
//Input:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//Output: []
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible trans
//formation.
// 
//
// 
// 
// Related Topics 广度优先搜索 数组 字符串 回溯算法

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.List;

public class WordLadderIi{
    public static void main(String[] args) {
       Solution solution = new WordLadderIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}