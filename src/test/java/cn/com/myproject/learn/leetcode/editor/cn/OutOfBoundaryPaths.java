//There is an m x n grid with a ball. The ball is initially at the position [sta
//rtRow, startColumn]. You are allowed to move the ball to one of the four adjacen
//t cells in the grid (possibly out of the grid crossing the grid boundary). You c
//an apply at most maxMove moves to the ball. 
//
// Given the five integers m, n, maxMove, startRow, startColumn, return the numb
//er of paths to move the ball out of the grid boundary. Since the answer can be v
//ery large, return it modulo 109 + 7. 
//
// 
// Example 1: 
//
// 
//Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
//Output: 6
// 
//
// Example 2: 
//
// 
//Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
//Output: 12
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 50 
// 0 <= maxMove <= 50 
// 0 <= startRow < m 
// 0 <= startColumn < n 
// 
// Related Topics 动态规划 
// 👍 188 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class OutOfBoundaryPaths{
    public static void main(String[] args) {
       Solution solution = new OutOfBoundaryPaths().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            final int MOD = 1000000007;
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int outCounts = 0;
            int[][][] dp = new int[maxMove + 1][m][n];
            dp[0][startRow][startColumn] = 1;
            for (int i = 0; i < maxMove; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        int count = dp[i][j][k];
                        if (count > 0) {
                            for (int[] direction : directions) {
                                int j1 = j + direction[0], k1 = k + direction[1];
                                if (j1 >= 0 && j1 < m && k1 >= 0 && k1 < n) {
                                    dp[i + 1][j1][k1] = (dp[i + 1][j1][k1] + count) % MOD;
                                } else {
                                    outCounts = (outCounts + count) % MOD;
                                }
                            }
                        }
                    }
                }
            }
            return outCounts;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}