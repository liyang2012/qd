//Given an integer num, return a string of its base 7 representation. 
//
// 
// Example 1: 
// Input: num = 100
//Output: "202"
// Example 2: 
// Input: num = -7
//Output: "-10"
// 
// 
// Constraints: 
//
// 
// -10⁷ <= num <= 10⁷ 
// 
// Related Topics 数学 👍 141 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class Base7{
    public static void main(String[] args) {
       Solution solution = new Base7().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }
            boolean negative = num < 0;
            num = Math.abs(num);
            StringBuilder digits = new StringBuilder();
            while (num > 0) {
                digits.append(num % 7);
                num /= 7;
            }
            if (negative) {
                digits.append('-');
            }
            return digits.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}