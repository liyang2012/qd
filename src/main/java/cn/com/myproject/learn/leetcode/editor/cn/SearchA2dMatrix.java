//Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the previou
//s row. 
// 
//
// Example 1: 
//
// 
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//Output: false 
// Related Topics 数组 二分查找

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class SearchA2dMatrix{
    public static void main(String[] args) {
       Solution solution = new SearchA2dMatrix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 二分查找
         * @param matrix
         * @param target
         * @return
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            if (m == 0) {
                return false;
            }
            int n = matrix[0].length;

            int left = 0, right = m * n - 1;
            int pivotIdx, pivoElement;
            while (left <= right) {
                pivotIdx = (left + right) / 2;
                pivoElement = matrix[pivotIdx / n][pivotIdx % n];
                if (pivoElement == target) {
                    return true;
                } else {
                    if (target < pivoElement) {
                        right = pivotIdx - 1;
                    } else {
                        left = pivotIdx + 1;
                    }
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}