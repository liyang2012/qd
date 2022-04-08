//
//Given a non-empty string s, you may delete at most one character. Judge whethe
//r you can make it a palindrome.
// 
//
// Example 1: 
// 
//Input: "aba"
//Output: True
// 
// 
//
// Example 2: 
// 
//Input: "abca"
//Output: True
//Explanation: You could delete the character 'c'.
// 
// 
//
// Note: 
// 
// The string will only contain lowercase characters a-z.
//The maximum length of the string is 50000. 
// 
// Related Topics 字符串

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class ValidPalindromeIi{
    public static void main(String[] args) {
       Solution solution = new ValidPalindromeIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            return validSubPalindrome(s, 0, s.length() - 1, false);
        }

        private boolean validSubPalindrome(String s, int lo, int hi, boolean used) {
            if (lo >= hi) { // base case
                return true;
            }

            if (s.charAt(lo) != s.charAt(hi)) { // equal
                if (used == false) {
                    if (validSubPalindrome(s, lo + 1, hi, true)) return true; // test left deletion
                    return validSubPalindrome(s, lo, hi - 1, true); // test right deletion
                } else {
                    return false;
                }
            }

            return validSubPalindrome(s, lo + 1, hi - 1, used);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}