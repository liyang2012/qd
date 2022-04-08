//Given an integer n, count the total number of digit 1 appearing in all non-neg
//ative integers less than or equal to n. 
//
// 
// Example 1: 
//
// 
//Input: n = 13
//Output: 6
// 
//
// Example 2: 
//
// 
//Input: n = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 109 
// 
// Related Topics 递归 数学 动态规划 
// 👍 310 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class NumberOfDigitOne{
    public static void main(String[] args) {
       Solution solution = new NumberOfDigitOne().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            // mulk 表示 10^k
            // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
            // 但为了让代码看起来更加直观，这里保留了 k
            long mulk = 1;
            int ans = 0;
            for (int k = 0; n >= mulk; ++k) {
                ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
                mulk *= 10;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}