//Given a non-empty list of words, return the k most frequent elements. 
// Your answer should be sorted by frequency from highest to lowest. If two word
//s have the same frequency, then the word with the lower alphabetical order comes
// first. 
//
// Example 1: 
// 
//Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//Output: ["i", "love"]
//Explanation: "i" and "love" are the two most frequent words.
//    Note that "i" comes before "love" due to a lower alphabetical order.
// 
// 
//
// Example 2: 
// 
//Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"]
//, k = 4
//Output: ["the", "is", "sunny", "day"]
//Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
//    with the number of occurrence being 4, 3, 2 and 1 respectively.
// 
// 
//
// Note: 
// 
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements. 
// Input words contain only lowercase letters. 
// 
// 
//
// Follow up: 
// 
// Try to solve it in O(n log k) time and O(n) extra space. 
// 
// Related Topics 堆 字典树 哈希表 
// 👍 317 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.*;

public class TopKFrequentWords{
    public static void main(String[] args) {
       Solution solution = new TopKFrequentWords().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> cnt = new HashMap<String, Integer>();
            for (String word : words) {
                cnt.put(word, cnt.getOrDefault(word, 0) + 1);
            }
            List<String> rec = new ArrayList<String>();
            for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
                rec.add(entry.getKey());
            }
            Collections.sort(rec, (word1, word2) -> cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1));
            return rec.subList(0, k);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}