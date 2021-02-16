//You are climbing a stair case. It takes n steps to reach to the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top? 
//
// Note: Given n will be a positive integer. 
//
// Example 1: 
//
// 
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
// Related Topics 动态规划

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class ClimbingStairs{
    public static void main(String[] args) {
       Solution solution = new ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 动态规划
         * @param n
         * @return
         */
        public int climbStairs(int n) {
            if(n<3) {
                return n;
            }
            int result = 2,l1 =1,l2=2;
            for(int i=3;i<=n;i++) {
                result = l1 + l2;
                l1 = l2;
                l2 = result;
            }
            return result;
        }
        /**
         * 动态规划
         * @param n
         * @return
         */
        public int climbStairs1(int n) {
            if(n<3) {
                return n;
            }
            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            for(int i=3;i<=n;i++) {
                dp[i] = dp[i-1]+dp[i-2];
            }
            return dp[n];
        }

        /**
         * 数学
         * FIXME
         * @param n
         * @return
         */
        public int climbStairs2(int n) {
            double sqrt5=Math.sqrt(5);
            double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
            return (int)(fibn/sqrt5);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}