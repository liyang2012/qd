//Given a non-negative integer c, decide whether there're two integers a and b s
//uch that a2 + b2 = c. 
//
// 
// Example 1: 
//
// 
//Input: c = 5
//Output: true
//Explanation: 1 * 1 + 2 * 2 = 5
// 
//
// Example 2: 
//
// s
//Input: c = 3
//Output: false
// 
//
// Example 3: 
//
// 
//Input: c = 4
//Output: true
// 
//
// Example 4: 
//
// 
//Input: c = 2
//Output: true
// 
//
// Example 5: 
//
// 
//Input: c = 1
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 0 <= c <= 231 - 1 
// 
// Related Topics 数学 
// 👍 248 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class SumOfSquareNumbers{
    public static void main(String[] args) {
       Solution solution = new SumOfSquareNumbers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            long left = 0;
            long right = (long) Math.sqrt(c);
            while (left <= right) {
                long sum = left * left + right * right;
                if (sum == c) {
                    return true;
                } else if (sum > c) {
                    right--;
                } else {
                    left++;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}