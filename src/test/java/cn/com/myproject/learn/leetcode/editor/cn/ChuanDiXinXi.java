//Related Topics 深度优先搜索 广度优先搜索 图 动态规划 
// 👍 88 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class ChuanDiXinXi{
    public static void main(String[] args) {
       Solution solution = new ChuanDiXinXi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWays(int n, int[][] relation, int k) {
            int[][] dp = new int[k + 1][n];
            dp[0][0] = 1;
            for (int i = 0; i < k; i++) {
                for (int[] edge : relation) {
                    int src = edge[0], dst = edge[1];
                    dp[i + 1][dst] += dp[i][src];
                }
            }
            return dp[k][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}