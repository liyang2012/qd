//English description is not available for the problem. Please switch to Chinese
//. Related Topics 数组

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.Arrays;

public class ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args) {
       Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null) {
                return new int[0];
            }
            int m = matrix.length;
            if (m == 0) {
                return new int[0];
            }
            int n = matrix[0].length;
            if (n == 0) {
                return new int[0];
            }
            int[] result = new int[m * n];
            int index = 0;
            int left = 0, right = n - 1, top = 0, bottom = m - 1;
            while (left <= right && top <= bottom) {
                for (int i = left; i <= right; i++) {
                    result[index++] = matrix[top][i];
                }

                for (int i = top + 1; i <= bottom; i++) {
                    result[index++] = matrix[i][right];
                }
                if (left < right && top < bottom) {
                    for (int i = right - 1; i > left; i--) {
                        result[index++] = matrix[bottom][i];
                    }

                    for (int i = bottom; i > top; i--) {
                        result[index++] = matrix[i][left];
                    }
                }
                left++;
                right--;
                top++;
                bottom--;
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}