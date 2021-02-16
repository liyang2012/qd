//Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 
//cents), and pennies (1 cent), write code to calculate the number of ways of repr
//esenting n cents. (The result may be large, so you should return it modulo 10000
//00007) 
//
// Example1: 
//
// 
// Input: n = 5
// Output: 2
// Explanation: There are two ways:
//5=5
//5=1+1+1+1+1
// 
//
// Example2: 
//
// 
// Input: n = 10
// Output: 4
// Explanation: There are four ways:
//10=10
//10=5+5
//10=5+1+1+1+1+1
//10=1+1+1+1+1+1+1+1+1+1
// 
//
// Notes: 
//
// You can assume: 
//
// 
// 0 <= n <= 1000000 
// 
// Related Topics 动态规划

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class CoinLcci{
    public static void main(String[] args) {
       Solution solution = new CoinLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int waysToChange(int n) {
            int[] dp = new int[n + 1];

            int[] coins = new int[]{1,5,10,25};


            //刚好可以用一个硬币凑成的情况，是一种情况
            // while i == coin :
            //dp[i] = dp[i - coin] => dp[0]
            dp[0] = 1;

            /**
             * dp方程：dp[i] += dp[i - coin];
             */

            for(int coin : coins) {
                for(int i = coin; i <= n; i++) {
                    dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
                }
            }

            return dp[n];
            
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}