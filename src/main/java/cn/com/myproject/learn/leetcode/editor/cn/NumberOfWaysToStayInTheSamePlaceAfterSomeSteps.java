//You have a pointer at index 0 in an array of size arrLen. At each step, you ca
//n move 1 position to the left, 1 position to the right in the array or stay in t
//he same place (The pointer should not be placed outside the array at any time). 
//
//
// Given two integers steps and arrLen, return the number of ways such that your
// pointer still at index 0 after exactly steps steps. 
//
// Since the answer may be too large, return it modulo 10^9 + 7. 
//
// 
// Example 1: 
//
// 
//Input: steps = 3, arrLen = 2
//Output: 4
//Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
//Right, Left, Stay
//Stay, Right, Left
//Right, Stay, Left
//Stay, Stay, Stay
// 
//
// Example 2: 
//
// 
//Input: steps = 2, arrLen = 4
//Output: 2
//Explanation: There are 2 differents ways to stay at index 0 after 2 steps
//Right, Left
//Stay, Stay
// 
//
// Example 3: 
//
// 
//Input: steps = 4, arrLen = 2
//Output: 8
// 
//
// 
// Constraints: 
//
// 
// 1 <= steps <= 500 
// 1 <= arrLen <= 10^6 
// 
// Related Topics 动态规划 
// 👍 160 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps{
    public static void main(String[] args) {
       Solution solution = new NumberOfWaysToStayInTheSamePlaceAfterSomeSteps().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWays(int steps, int arrLen) {
            final int MODULO = 1000000007;
            int maxColumn = Math.min(arrLen - 1, steps);
            int[][] dp = new int[steps + 1][maxColumn + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= steps; i++) {
                for (int j = 0; j <= maxColumn; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j - 1 >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MODULO;
                    }
                    if (j + 1 <= maxColumn) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MODULO;
                    }
                }
            }
            return dp[steps][0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}