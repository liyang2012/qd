//Given an integer n, return true if n is an ugly number. 
//
// Ugly number is a positive number whose prime factors only include 2, 3, and/o
//r 5. 
//
// 
// Example 1: 
//
// 
//Input: n = 6
//Output: true
//Explanation: 6 = 2 × 3 
//
// Example 2: 
//
// 
//Input: n = 8
//Output: true
//Explanation: 8 = 2 × 2 × 2
// 
//
// Example 3: 
//
// 
//Input: n = 14
//Output: false
//Explanation: 14 is not ugly since it includes another prime factor 7.
// 
//
// Example 4: 
//
// 
//Input: n = 1
//Output: true
//Explanation: 1 is typically treated as an ugly number.
// 
//
// 
// Constraints: 
//
// 
// -231 <= n <= 231 - 1 
// 
// Related Topics 数学 
// 👍 195 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class UglyNumber{
    public static void main(String[] args) {
       Solution solution = new UglyNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUgly(int n) {
            if (n <= 0) {
                return false;
            }
            int[] factors = {2, 3, 5};
            for (int factor : factors) {
                while (n % factor == 0) {
                    n /= factor;
                }
            }
            return n == 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}