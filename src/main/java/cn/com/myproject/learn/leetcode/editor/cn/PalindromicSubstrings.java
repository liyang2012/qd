//Given a string, your task is to count how many palindromic substrings in this 
//string. 
//
// The substrings with different start indexes or end indexes are counted as dif
//ferent substrings even they consist of same characters. 
//
// Example 1: 
//
// 
//Input: "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
// 
//
// 
//
// Example 2: 
//
// 
//Input: "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 
//
// Note: 
//
// 
// The input string length won't exceed 1000. 
// 
//
// Related Topics 字符串 动态规划

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class PalindromicSubstrings{
    public static void main(String[] args) {
       Solution solution = new PalindromicSubstrings().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int n = s.length(), ans = 0;
            for (int center = 0; center <= 2*n-1; ++center) {
                int left = center / 2;
                int right = left + center % 2;
                while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                    ans++;
                    left--;
                    right++;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}