//Given an integer, write a function to determine if it is a power of two. 
//
// Example 1: 
//
// 
//Input: 1
//Output: true 
//Explanation: 20 = 1
// 
//
// Example 2: 
//
// 
//Input: 16
//Output: true
//Explanation: 24 = 16 
//
// Example 3: 
//
// 
//Input: 218
//Output: false 
// Related Topics 位运算 数学

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class PowerOfTwo{
    public static void main(String[] args) {
       Solution solution = new PowerOfTwo().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n == 0) {
                return false;
            }
            long x = (long) n;
            return (x & (x - 1)) == 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}