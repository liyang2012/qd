//Given two words (beginWord and endWord), and a dictionary's word list, find th
//e length of shortest transformation sequence from beginWord to endWord, such tha
//t: 
//
// 
// Only one letter can be changed at a time. 
// Each transformed word must exist in the word list. 
// 
//
// Note: 
//
// 
// Return 0 if there is no such transformation sequence. 
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
//Output: 5
//
//Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog
//" -> "cog",
//return its length 5.
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
//Output: 0
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible trans
//formation.
// 
//
// 
// 
// Related Topics 广度优先搜索

  
package cn.com.myproject.learn.leetcode.editor.cn;

import javafx.util.Pair;
import net.sf.jsqlparser.expression.operators.relational.LikeExpression;
import org.apache.ibatis.annotations.Param;

import java.util.*;

public class WordLadder{
    public static void main(String[] args) {
       Solution solution = new WordLadder().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            int l = beginWord.length();
            Map<String, List<String>> allComboDict = new HashMap<>();
            wordList.forEach(
                    word -> {
                        for (int i = 0; i < l; i++) {
                            String newWord = word.substring(0, i) + "*" + word.substring(i + 1, l);
                            List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                            transformations.add(word);
                            allComboDict.put(newWord, transformations);
                        }
                    }
            );
            Queue<Pair<String, Integer>> q = new LinkedList<>();
            q.add(new Pair<>(beginWord, 1));

            Map<String, Boolean> visited = new HashMap<>();
            visited.put(beginWord, true);
            while (!q.isEmpty()) {
                Pair<String, Integer> node = q.remove();
                String word = node.getKey();
                int level = node.getValue();
                for (int i = 0; i < l; i++) {
                    String newWord = word.substring(0, i) + "*" + word.substring(i + 1, l);

                    for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                        if (adjacentWord.equals(endWord)) {
                            return level + 1;
                        }
                        if (!visited.containsKey(adjacentWord)) {
                            visited.put(adjacentWord, true);
                            q.add(new Pair<>(adjacentWord, level + 1));
                        }
                    }
                }
            }
            return 0;
        }

        /***
         * FIXME
         * @param beginWord
         * @param endWord
         * @param wordList
         * @return
         */
        public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
            int end = wordList.indexOf(endWord);
            if (end == -1) {
                return 0;
            }
            wordList.add(beginWord);

            // 从两端BFS遍历要用的队列
            Queue<String> queue1 = new LinkedList<>();
            Queue<String> queue2 = new LinkedList<>();
            // 两端已经遍历过的节点
            Set<String> visited1 = new HashSet<>();
            Set<String> visited2 = new HashSet<>();
            queue1.offer(beginWord);
            queue2.offer(endWord);
            visited1.add(beginWord);
            visited2.add(endWord);

            int count = 0;
            Set<String> allWordSet = new HashSet<>(wordList);

            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                count++;
                if (queue1.size() > queue2.size()) {
                    Queue<String> tmp = queue1;
                    queue1 = queue2;
                    queue2 = tmp;
                    Set<String> t = visited1;
                    visited1 = visited2;
                    visited2 = t;
                }
                int size1 = queue1.size();
                while (size1-- > 0) {
                    String s = queue1.poll();
                    char[] chars = s.toCharArray();
                    for (int j = 0; j < s.length(); ++j) {
                        // 保存第j位的原始字符
                        char c0 = chars[j];
                        for (char c = 'a'; c <= 'z'; ++c) {
                            chars[j] = c;
                            String newString = new String(chars);
                            // 已经访问过了，跳过
                            if (visited1.contains(newString)) {
                                continue;
                            }
                            // 两端遍历相遇，结束遍历，返回count
                            if (visited2.contains(newString)) {
                                return count + 1;
                            }
                            // 如果单词在列表中存在，将其添加到队列，并标记为已访问
                            if (allWordSet.contains(newString)) {
                                queue1.offer(newString);
                                visited1.add(newString);
                            }
                        }
                        // 恢复第j位的原始字符
                        chars[j] = c0;
                    }
                }
            }
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}