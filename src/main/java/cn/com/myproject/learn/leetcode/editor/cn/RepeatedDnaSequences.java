//The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 
//'C', 'G', and 'T'. 
//
// 
// For example, "ACGAATTCCG" is a DNA sequence. 
// 
//
// When studying DNA, it is useful to identify repeated sequences within the 
//DNA. 
//
// Given a string s that represents a DNA sequence, return all the 10-letter-
//long sequences (substrings) that occur more than once in a DNA molecule. You may 
//return the answer in any order. 
//
// 
// Example 1: 
// Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//Output: ["AAAAACCCCC","CCCCCAAAAA"]
// Example 2: 
// Input: s = "AAAAAAAAAAAAA"
//Output: ["AAAAAAAAAA"]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is either 'A', 'C', 'G', or 'T'. 
// 
// Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希 👍 228 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDnaSequences{
    public static void main(String[] args) {
        Solution solution = new RepeatedDnaSequences().new Solution();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(solution.findRepeatedDnaSequences(s).toString());
        System.out.println(System.currentTimeMillis());
        System.out.println(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        System.out.println(Integer.MAX_VALUE);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int LEN = 10;
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> result = new ArrayList<>();
            int l = s.length();
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i <= l - LEN ; i++) {
                String str = s.substring(i, i + LEN);
                map.put(str, map.getOrDefault(str, 0) + 1);
                if (map.get(str) == 2) {
                    result.add(str);
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}