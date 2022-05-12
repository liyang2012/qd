//有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。 
//
// 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上
//单元格 高于海平面的高度 。 
//
// 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。 
//
// 返回 网格坐标 result 的 2D列表 ，其中 result[i] = [ri, ci] 表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋
// 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// 
//
// 示例 2： 
//
// 
//输入: heights = [[2,1],[1,2]]
//输出: [[0,0],[0,1],[1,0],[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 10⁵ 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 384 👎 0


package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow{
    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] heights;
        int m, n;

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            this.heights = heights;
            this.m = heights.length;
            this.n = heights[0].length;
            boolean[][] pacific = new boolean[m][n];
            boolean[][] atlantic = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                dfs(i, 0, pacific);
            }
            for (int j = 1; j < n; j++) {
                dfs(0, j, pacific);
            }
            for (int i = 0; i < m; i++) {
                dfs(i, n - 1, atlantic);
            }
            for (int j = 0; j < n - 1; j++) {
                dfs(m - 1, j, atlantic);
            }
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (pacific[i][j] && atlantic[i][j]) {
                        List<Integer> cell = new ArrayList<Integer>();
                        cell.add(i);
                        cell.add(j);
                        result.add(cell);
                    }
                }
            }
            return result;
        }

        public void dfs(int row, int col, boolean[][] ocean) {
            if (ocean[row][col]) {
                return;
            }
            ocean[row][col] = true;
            for (int[] dir : dirs) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && heights[newRow][newCol] >= heights[row][col]) {
                    dfs(newRow, newCol, ocean);
                }
            }
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}