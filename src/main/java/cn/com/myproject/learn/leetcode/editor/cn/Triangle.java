//Given a triangle, find the minimum path sum from top to bottom. Each step you 
//may move to adjacent numbers on the row below. 
//
// For example, given the following triangle 
//
// 
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
//
// Note: 
//
// Bonus point if you are able to do this using only O(n) extra space, where n i
//s the total number of rows in the triangle. 
// Related Topics 数组 动态规划

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.List;

public class Triangle{
    public static void main(String[] args) {
       Solution solution = new Triangle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 自底向上
         * @param triangle
         * @return
         */
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) {
                return 0;
            }
            int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];

            for (int i = triangle.size() - 1; i >= 0; i--) {
                List<Integer> rows = triangle.get(i);
                for (int j = 0; j < rows.size(); j++) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + rows.get(j);
                }

            }
            return dp[0][0];
        }

        public int minimumTotal1(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) {
                return 0;
            }
            int[] dp = new int[triangle.size() + 1];

            for (int i = triangle.size() - 1; i >= 0; i--) {
                List<Integer> rows = triangle.get(i);
                for (int j = 0; j < rows.size(); j++) {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + rows.get(j);
                }
            }
            return dp[0];
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}