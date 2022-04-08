//In MATLAB, there is a handy function called reshape which can reshape an m x 
//n matrix into a new one with a different size r x c keeping its original data. 
//
// You are given an m x n matrix mat and two integers r and c representing the 
//number of rows and the number of columns of the wanted reshaped matrix. 
//
// The reshaped matrix should be filled with all the elements of the original 
//matrix in the same row-traversing order as they were. 
//
// If the reshape operation with given parameters is possible and legal, output 
//the new reshaped matrix; Otherwise, output the original matrix. 
//
// 
// Example 1: 
//
// 
//Input: mat = [[1,2],[3,4]], r = 1, c = 4
//Output: [[1,2,3,4]]
// 
//
// Example 2: 
//
// 
//Input: mat = [[1,2],[3,4]], r = 2, c = 4
//Output: [[1,2],[3,4]]
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 100 
// -1000 <= mat[i][j] <= 1000 
// 1 <= r, c <= 300 
// 
// Related Topics 数组 矩阵 模拟 👍 282 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.Arrays;

public class ReshapeTheMatrix{
    public static void main(String[] args) {
       Solution solution = new ReshapeTheMatrix().new Solution();
       int[][] mat = new int[][]{{1,2},{3,4},{5,6}};
       int[][] result = solution.matrixReshape(mat, 2, 3);
       for (int[] i : result) {
           System.out.println(Arrays.toString(i));
       }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] matrixReshape1(int[][] mat, int r, int c) {
            int i = mat.length;
            int j = mat[0].length;
            if (i * j != r * c) {
                return mat;
            }
            int[][] result = new int[r][c];
            int num = 0;
            for (int ii = 0; ii < i; ii++) {
                for (int jj = 0; jj < j; jj++) {
                    int a1 = num / c;
                    int a2 = num % c;
                    result[a1][a2] = mat[ii][jj];
                    num++;
                }
            }
            return result;
        }

        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int m = nums.length;
            int n = nums[0].length;
            if (m * n != r * c) {
                return nums;
            }

            int[][] ans = new int[r][c];
            for (int x = 0; x < m * n; ++x) {
                ans[x / c][x % c] = nums[x / n][x % n];
            }
            return ans;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}