//The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibon
//acci sequence, such that each number is the sum of the two preceding ones, start
//ing from 0 and 1. That is, 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), for N > 1.
// 
//
// Given N, calculate F(N). 
//
// 
//
// Example 1: 
//
// 
//Input: 2
//Output: 1
//Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// Example 2: 
//
// 
//Input: 3
//Output: 2
//Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// Example 3: 
//
// 
//Input: 4
//Output: 3
//Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
//
// Note: 
//
// 0 ≤ N ≤ 30. 
// Related Topics 数组

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class FibonacciNumber{
    public static void main(String[] args) {
        Solution solution = new FibonacciNumber().new Solution();
        System.out.println(solution.fib(3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            }
            int n0 = 0;
            int n1 = 1;
            for (int i = 2; i <= n; i++) {
                int tmp = n0 + n1;
                n0 = n1;
                n1 = tmp;
            }
            return n1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}