//Given an m x n matrix matrix and an integer k, return the max sum of a rectang
//le in the matrix such that its sum is no larger than k. 
//
// It is guaranteed that there will be a rectangle with a sum no larger than k. 
//
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,0,1],[0,-2,3]], k = 2
//Output: 2
//Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and
// 2 is the max number no larger than k (k = 2).
// 
//
// Example 2: 
//
// 
//Input: matrix = [[2,2,-1]], k = 3
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -100 <= matrix[i][j] <= 100 
// -105 <= k <= 105 
// 
//
// 
// Follow up: What if the number of rows is much larger than the number of colum
//ns? 
// Related Topics 队列 二分查找 动态规划 
// 👍 275 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.TreeSet;

public class MaxSumOfRectangleNoLargerThanK{
    public static void main(String[] args) {
       Solution solution = new MaxSumOfRectangleNoLargerThanK().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int ans = Integer.MIN_VALUE;
            int m = matrix.length, n = matrix[0].length;
            for (int i = 0; i < m; ++i) { // 枚举上边界
                int[] sum = new int[n];
                for (int j = i; j < m; ++j) { // 枚举下边界
                    for (int c = 0; c < n; ++c) {
                        sum[c] += matrix[j][c]; // 更新每列的元素和
                    }
                    TreeSet<Integer> sumSet = new TreeSet<Integer>();
                    sumSet.add(0);
                    int s = 0;
                    for (int v : sum) {
                        s += v;
                        Integer ceil = sumSet.ceiling(s - k);
                        if (ceil != null) {
                            ans = Math.max(ans, s - ceil);
                        }
                        sumSet.add(s);
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}