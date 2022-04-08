//Given a string, determine if it is a palindrome, considering only alphanumeric
// characters and ignoring cases. 
//
// Note: For the purpose of this problem, we define empty string as valid palind
//rome. 
//
// Example 1: 
//
// 
//Input: "A man, a plan, a canal: Panama"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "race a car"
//Output: false
// 
// Related Topics 双指针 字符串

  
package cn.com.myproject.learn.leetcode.editor.cn;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome{
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();

        System.out.println( solution.isPalindrome("A man, a plan, a canal: Panama"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.isEmpty()) {
                return true;
            }
            char[] c = s.toCharArray();
            int l = 0, r = c.length - 1;
            while (l <= r) {
                while (!isDis(c[l]) && l < r) {
                    l++;
                }
                while (!isDis(c[r])  && l < r) {
                    r--;
                }
               // System.out.println(l + "," + r);

                if (to(c[l]) == to(c[r])) {
                    l++;
                    r--;
                    continue;
                } else {
                    return false;
                }

            }
            return true;
        }
        private boolean isDis(char c) {
            if ((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                return true;
            }
            return false;
        }

        private char to(char c) {
            if (c >= 97 && c <= 122) {
                return (char) (c - 32);
            }
            return c;
        }


        public boolean isPalindrome1(String s) {
            if (s.isEmpty()) {
                return true;
            }
            int head = 0, tail = s.length() - 1;
            char cHead, cTail;
            while(head <= tail) {
                cHead = s.charAt(head);
                cTail = s.charAt(tail);
                if (!Character.isLetterOrDigit(cHead)) {
                    head++;
                } else if(!Character.isLetterOrDigit(cTail)) {
                    tail--;
                } else {
                    if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                        return false;
                    }
                    head++;
                    tail--;
                }
            }

            return true;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


}