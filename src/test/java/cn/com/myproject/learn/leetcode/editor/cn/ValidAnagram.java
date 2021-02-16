//Given two strings s and t , write a function to determine if t is an anagram o
//f s. 
//
// Example 1: 
//
// 
//Input: s = "anagram", t = "nagaram"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "rat", t = "car"
//Output: false
// 
//
// Note: 
//You may assume the string contains only lowercase alphabets. 
//
// Follow up: 
//What if the inputs contain unicode characters? How would you adapt your soluti
//on to such case? 
// Related Topics 排序 哈希表

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.Arrays;

public class ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
        String s = "anagram", t = "nagaram";
        System.out.println(solution.isAnagram(s, t));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * api
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagram1(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            char[] sc = s.toCharArray();
            char[] tc = t.toCharArray();
            Arrays.sort(sc);
            Arrays.sort(tc);
            return Arrays.equals(sc, tc);
        }

        /**
         * hash
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagram2(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] counter = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counter[s.charAt(i) - 'a']++;
                counter[t.charAt(i) - 'a']--;
            }
            for (int count : counter) {
                if (count != 0) {
                    return false;
                }
            }
            return true;
        }
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] table = new int[26];
            for (int i = 0; i < s.length(); i++) {
                table[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                table[t.charAt(i) - 'a']--;
                if (table[t.charAt(i) - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}