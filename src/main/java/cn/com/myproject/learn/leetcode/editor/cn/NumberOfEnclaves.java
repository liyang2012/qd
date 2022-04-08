//You are given an m x n binary matrix grid, where 0 represents a sea cell and 1
// represents a land cell. 
//
// A move consists of walking from one land cell to another adjacent (4-
//directionally) land cell or walking off the boundary of the grid. 
//
// Return the number of land cells in grid for which we cannot walk off the 
//boundary of the grid in any number of moves. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//Output: 3
//Explanation: There are three 1s that are enclosed by 0s, and one 1 that is 
//not enclosed because its on the boundary.
// 
//
// Example 2: 
//
// 
//Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//Output: 0
//Explanation: All 1s are either on the boundary or can reach the boundary.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] is either 0 or 1. 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 143 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class NumberOfEnclaves{
    public static void main(String[] args) {
       Solution solution = new NumberOfEnclaves().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numEnclaves(int[][] grid) {
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}